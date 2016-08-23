public class SphereCalc4 {
  private double radius, area, volume;

  public SphereCalc4( double r) {
    radius = r;
    area = 4*Math.PI*r*r;
    volume = 4*Math.PI*Math.pow(r,3) / 3.0;
  }

  public void setRadius( double r) {
    radius = r;
    area = 4*Math.PI*r*r;
    volume = 4*Math.PI*Math.pow(r,3) / 3.0;
  }

  public double getRadius()       {return radius; }
  public double getSurfaceArea()  {return area; }
  public double getVolume()       {return volume; }
}
