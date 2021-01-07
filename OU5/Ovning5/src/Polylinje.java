import java.util.Arrays;

public class Polylinje {

    private Punkt[] horn;
    private String farg = "svart";
    private int bredd = 1;

    public Polylinje() {
        this.horn = new Punkt[0];
    }

    public Polylinje(Punkt[] horn) {
        this.horn = new Punkt[horn.length];
        for (int i = 0; i < horn.length; i++)
            this.horn[i] = new Punkt(horn[i]);
    }

    public String toString() {
        if (this.horn[this.horn.length - 1] == null){
            return "ERROR PUNKT COULD NOT BE FOUND";
        }
        return (Arrays.toString(this.horn) + ", " + this.farg + ", " + this.bredd);

    }
    public Punkt[] getHorn() {
        Punkt[] getHorn = new Punkt[this.horn.length];
        for (int i = 0; i < this.horn.length; i++) {
            getHorn[i] = this.horn[i];
        }
        return getHorn;
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

    public double langd() {
        double langd = 0;
        for (int i = 0; i < this.horn.length - 1; i++) {
            langd += this.horn[i].avstand(this.horn[i + 1]);
        }
        return langd;
    }

    public void laggTill(Punkt horn) {
        Punkt[] h = new Punkt[this.horn.length + 1];
        int i = 0;
        for (i = 0; i < this.horn.length; i++)
            h[i] = this.horn[i];
        h[i] = new Punkt(horn);

        this.horn = h;
    }

    public void laggTillFramfor(Punkt horn, String hornNamn) {
        Punkt[] temp = new Punkt[this.horn.length + 1];
        int i = 0;
        for (i = 0; i < this.horn.length; i++) {
            if (hornNamn.equals(this.horn[i].getNamn())) {
                temp[i] = horn;

                break;
            } else {
                temp[i] = this.horn[i];
            }
        }
        for (i = i; i < this.horn.length; i++)
            temp[i + 1] = this.horn[i];
        this.horn = temp;
    }

    public void taBort(String hornNamn) {
        Punkt[] temp = new Punkt[this.horn.length - 1];
        int i = 0;
        for (i = 0; i < this.horn.length; i++) {
            if (hornNamn.equals(this.horn[i].getNamn())) {
                for (i = i; i < temp.length; i++)
                    temp[i] = this.horn[i + 1];
                break;
            } else {
                temp[i] = this.horn[i];
            }
        }
        this.horn = temp;
    }

    public class PolylinjeIterator{
        private int aktuell = -1;
        public PolylinjeIterator(){
            if (Polylinje.this.horn.length > 0)
                aktuell = 0;
        }
        public boolean finnsHorn(){
            return aktuell != -1;
        }
        public Punkt horn() throws java.util.NoSuchElementException{
            if (!this.finnsHorn())
                throw new java.util.NoSuchElementException("Slut på iterationen");

            Punkt horn = Polylinje.this.horn[aktuell];
            return horn;
        }

        public void gaFram(){
            if(aktuell >= 0 &&
            aktuell < Polylinje.this.horn.length - 1)
                aktuell++;
            else
                aktuell = -1;
        }

        public void printPunkt(){
            while(this.finnsHorn()){
                var tempHorn = horn();
                System.out.println(tempHorn);
                gaFram();
            }
        }

    }
}


