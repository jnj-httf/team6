package com.example.team6.util;

public final class DistanceCalculatorUtil
{
    /**
     * Performs a calc to discover the distance between two points lat/long.
     *
     * @param lat1 Latitude of the first point.
     * @param lon1 Longitude of the first point.
     * @param lat2 Latitude of the second point.
     * @param lon2 Longitude of the second point.
     * @return Distance calculated in the unit passed.
     */
    public static double distance(double lat1, double lon1, double lat2, double lon2)
    {
        double theta = lon1 - lon2;
        double dist =
            Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2))
                * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist *= 60 * 1.1515;
        dist *= 1.609344;

        return dist;
    }

    /**
     * Convert degree to radians.
     *
     * @param deg Degree value
     * @return Degrees converted to Radians
     */
    private static double deg2rad(double deg)
    {
        return (deg * Math.PI / 180.0);
    }

    /**
     * Convert randians to degree.
     *
     * @param rad Radian value
     * @return Radians converted to Degrees
     */
    private static double rad2deg(double rad)
    {
        return (rad * 180 / Math.PI);
    }
}
