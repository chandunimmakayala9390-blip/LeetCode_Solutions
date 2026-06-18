class Solution {
    public double angleClock(int hour, int minutes) {
        double h_angle = 0.0;
        if (hour == 12) {
            h_angle = ((minutes/60.0) * 30.0);
        }
        else {
            h_angle = ((minutes/60.0) * 30.0) + (30.0 * hour);
        }
        double m_angle = (minutes * 6.0);
        double first = Math.abs(h_angle - m_angle);
        double second = 360.0 - first;
        return Math.min(first,second);
    }
}