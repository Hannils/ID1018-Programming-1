
    public class Punkt {
        String namn;
        int x, y;

        public Punkt(String namn, int x, int y) {
            this.namn = namn;
            this.x = x;
            this.y = y;
        }

        public String getNamn() {
            return this.namn;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        public double avstand(Punkt p2) {
            double x1 = p2.getX() - this.x;
            double y1 = p2.getY() - this.y;
            double avstand = Math.sqrt(Math.pow(x1, 2) + Math.pow(y1, 2));
            return avstand;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public Punkt(Punkt punkt){
            this.namn = punkt.namn;
            this.x = punkt.x;
            this.y = punkt.y;
        }

        public  String toString() {

            return "(" + this.namn + " " + this.x + " " + this.y + ")";
        }

    }

