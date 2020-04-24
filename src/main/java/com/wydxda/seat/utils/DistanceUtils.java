package com.wydxda.seat.utils;

import org.gavaghan.geodesy.Ellipsoid;
import org.gavaghan.geodesy.GeodeticCalculator;
import org.gavaghan.geodesy.GeodeticCurve;
import org.gavaghan.geodesy.GlobalCoordinates;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * //    http://www.gpsspg.com/distance.htm
 * @author li-fengjie
 */
public class DistanceUtils {

    private static final double MAX_ALLOW_METER = 300;

    @Autowired
    public static boolean allowedDistance(
            double fromLatitude,
            double fromLonitude,
            double toLatitude,
            double toLongitude
    ){


        GlobalCoordinates source = new GlobalCoordinates(fromLatitude, fromLonitude);
        GlobalCoordinates target = new GlobalCoordinates(toLatitude, toLongitude);

//        double meter1 = getDistanceMeter(source, target, Ellipsoid.Sphere);
        double meter = getDistanceMeter(source, target, Ellipsoid.WGS84);

//        System.out.println("Sphere坐标系计算结果："+meter1 + "米");
        System.out.println("WGS84坐标系计算距离结果："+ meter + "米");
        return meter < MAX_ALLOW_METER;
    }


    @Autowired
    public static double getDistanceMeter(GlobalCoordinates gpsFrom, GlobalCoordinates gpsTo, Ellipsoid ellipsoid){

        //创建GeodeticCalculator，调用计算方法，传入坐标系、经纬度用于计算距离
        GeodeticCurve geoCurve = new GeodeticCalculator().calculateGeodeticCurve(ellipsoid, gpsFrom, gpsTo);

        return geoCurve.getEllipsoidalDistance();
    }
}
