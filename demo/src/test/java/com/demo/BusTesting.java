package com.demo;

import com.demo.entity.Bus;
import com.demo.entity.Stops;
import com.demo.repository.BusRepository;
import com.demo.repository.StopRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class BusTesting {

    @Autowired
    private StopRepository stopRepository;

    @Autowired
    private BusRepository busRepository;

@Test
   public void createBusWithStops(){
    Stops s1 = new Stops();
    s1.setStopName("SilkBoard");

    Stops s2 = new Stops();
    s2.setStopName("BTM Layout");

    Stops s3 = new Stops();
    s3.setStopName("Water tank");

    stopRepository.saveAll(Arrays.asList(s1,s2,s3));

    Bus b1 = new Bus();
    b1.setBusName("101 Pink");
    b1.setStops(Arrays.asList(s1,s2));
    Bus b2 = new Bus();
    b2.setBusName("043 Red");
    b2.setStops(Arrays.asList(s2,s3));
    Bus b3 = new Bus();
    b3.setBusName("103 Yellow");
    b3.setStops(Arrays.asList(s3,s1));

    busRepository.saveAll(Arrays.asList(b1,b2,b3));


    }
}
