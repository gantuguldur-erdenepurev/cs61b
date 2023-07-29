public class NBody{

    public static double readRadius(String planetsTxtPath){
        In in = new In(planetsTxtPath);
        int N = in.readInt();
        double R = in.readDouble();
        return R;

    }
    
    public static Planet[] readPlanets(String planetsTxtPath){
        In in = new In(planetsTxtPath);

        int N = in.readInt();
        double R = in.readDouble();
        
        Planet[] output = new Planet[N];
        
        for (int i = 0; i < N; i++) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();

            Planet p = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
            output[i] = p;
        }
        return output;
    }

    public static void main(String[] args){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double R = readRadius(filename);
        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);
        StdDraw.setScale(-R, R);
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0, 0, "images/starfield.jpg");
        int n = planets.length;

      
        for (Planet p: planets){
            p.draw();
        }

        StdDraw.pause(2000);
        StdDraw.enableDoubleBuffering();

        for (double t = 0; t < T; t += dt){
            double[] xForces = new double[n];
            double[] yForces = new double[n];
            for (int i = 0; i < n; i += 1){
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            
            for (int i = 0; i < n; i++){
                planets[i].update(dt, xForces[i], yForces[i]);
            }

            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Planet p: planets){
                p.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
        
        }

        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
        StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
        }
    }

}