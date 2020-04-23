package com.wydxda.seat;

import com.wydxda.seat.utils.DistanceUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DistanceTests {
    @Test
    public void allowedDistanceTest() {

//        36.97542,115.26669
//        37.145894097222225,115.32984890407987
        System.out.println(DistanceUtils.allowedDistance(
                36.97542,115.26669,
                37.145894097222225,115.32984890407987
        ));
    }
}
