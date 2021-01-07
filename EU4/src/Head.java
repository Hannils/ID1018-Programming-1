public class Head {

  public static void main(String[] args) {
    Polylinje polylinje = null;
    //polylinje = new NPolylinje (); // (1)
    polylinje = new VPolylinje (); // (2)
    polylinje.laggTill(new Punkt("A", 2, 4));
    polylinje.laggTill(new Punkt("B", 6, 1));
    polylinje.laggTill(new Punkt("C", 8, 12));
    polylinje.laggTill(new Punkt("D", 4, 2));
    polylinje.laggTill(new Punkt("E", 14, 8));

    System.out.println(polylinje);

    polylinje.taBort("A");
    polylinje.laggTillFramfor(new Punkt("Z", 5, 4), "E");

    polylinje.setFarg("red");

    System.out.println(polylinje);

    for (Punkt horn : polylinje)
      System.out.println (horn);

    Polylinje[] slumpade = new Polylinje[10];
    for (int i = 0; i < 10; i++)
      slumpade[i] = ValjPolylinje.slumpPolylinje();


    System.out.println(Polylinjer.shortestYellow(slumpade));
  }

}


