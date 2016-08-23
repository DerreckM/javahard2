public class SphereCalc {
  double radius;
  //setter method or mutator
  public void setRadius( double r ) {
    radius = r;
  }
  //getter method or accessor
  public double getRadius() {
    return radius;
  }

  public double getSurfaceArea() {
    return 4*Math.PI*radius*radius;
  }

  public double getVolume() {
    return 4*Math.PI*Math.pow(radius, 3) / 3.0;
  }
}
