public class Planet {
    public double xxPos, yyPos, xxVel, yyVel, mass;
    public String imgFileName;
    private static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV,
              double yV, double m, String img){
                this.xxPos = xP;
                this.yyPos = yP;
                this.xxVel = xV;
                this.yyVel = yV;
                this.mass = m;
                this.imgFileName = img;
              }

    public Planet(Planet p){
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }   

    public double calcDistance(Planet p){
        double dx = p.xxPos - this.xxPos;
        double dy = p.yyPos - this.yyPos;
        double r_squared = dx*dx + dy*dy;
        return Math.sqrt(r_squared);
    }

    public double calcForceExertedBy(Planet p){
        double F = (G * this.mass * p.mass)/(calcDistance(p) * calcDistance(p));
        return F;
    }

    public double calcForceExertedByX(Planet p){
        double dx = p.xxPos - this.xxPos;
        return (calcForceExertedBy(p) * dx)/calcDistance(p);
    }

    public double calcForceExertedByY(Planet p){
        double dy = p.yyPos - this.yyPos;
        return (calcForceExertedBy(p) * dy)/calcDistance(p);
    }

    public double calcNetForceExertedByX(Planet[] allPlanets){
        double total = 0;
        for (Planet s: allPlanets){
            if (!this.equals(s)){
                total += calcForceExertedByX(s);
            }
        }
        return total;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets){
        double total = 0;
        for (Planet s: allPlanets){
            if (!this.equals(s)){
                total += calcForceExertedByY(s);
            }
        }
        return total;
    }
    
    public void update(double dt, double fX, double fY){
        double aX = fX/this.mass;
        double aY = fY/this.mass;
        this.xxVel = this.xxVel + dt * aX;
        this.yyVel = this.yyVel + dt * aY; 
        this.xxPos = this.xxPos + dt * this.xxVel;
        this.yyPos = this.yyPos + dt * this.yyVel;
    }

    public void draw(){
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
        StdDraw.show();
    }

}