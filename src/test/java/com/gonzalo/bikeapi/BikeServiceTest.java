package com.gonzalo.bikeapi;

import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.gonzalo.bikeapi.exception.BikeWithItemNotFoundException;
import com.gonzalo.bikeapi.repository.BikeRepository;
import com.gonzalo.bikeapi.service.BikeServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class BikeServiceTest {
    @Mock
    private BikeRepository bikeRepository;
    @InjectMocks
    private BikeServiceImpl bikeService;

    @Test(expected = BikeWithItemNotFoundException.class)
    public void findByNameTest() {
        when(bikeRepository.findByItems_Type("PEDALES")).thenReturn(Arrays.asList());
        bikeService.findByItemType("PEDALES");
}
}
