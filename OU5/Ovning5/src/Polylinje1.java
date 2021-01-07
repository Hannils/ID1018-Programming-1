import java.util.Arrays;

public class Polylinje1 {

        private Punkt[] horn;
        private String farg = "svart";
        private int bredd = 1;

        public Polylinje1 () {
            this.horn = new Punkt[0];
        }

        public Polylinje1 (Punkt[] horn) {
            this.horn = new Punkt[horn.length];
            for (int i = 0; i < horn.length; i++)
                this.horn[i] = new Punkt(horn[i]);
        }

        public Punkt[] getHorn() {
            return horn;
        }

        public String getFarg() {
            return this.farg;
        }

        public int getBredd() {
            return this.bredd;
        }

        public void setFarg(String farg) {
            this.farg = farg;
        }

        public void setBredd(int bredd) {
            this.bredd = bredd;
        }
    }




