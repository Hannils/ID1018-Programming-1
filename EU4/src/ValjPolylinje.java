import java.util.Random;

public class ValjPolylinje {

  public static final Random rand = new Random();
  public static final int  ANTAL_POLYLINJER = 10;
  private static Polylinje[] polylinjer;
  public static int k = 0;


  public static Punkt slumpPunkt(){
	String n = "" + (char)(65 + rand.nextInt(26));
	int x = rand.nextInt(11);
	int y = rand.nextInt(11);

	return new Punkt(n, x, y);
  }

  public static Polylinje slumpPolylinje(){
	//Skapa en tom polylinje, och lägg till hörn till den
	Random slumpis = new Random();
	Polylinje polylinje = new VPolylinje();

		if(k == 1 || k == 3 || k == 5 || k == 7 || k == 9){
		  polylinje = new VPolylinje();
		  k++;
		}
		else{
		   polylinje = new NPolylinje();
		   k++;
		}
	  //Polylinje polylinje = new VPolylinje();
	  int antalHorn = 2 + rand.nextInt(7);
	  int antalValdahorn = 0;
	  boolean[] valdaNamn = new boolean[26];
	  //Ett och samma namn kan inte förekomma flera gånger
	  Punkt valdPunkt = null;
	  char valdChar = 0;


	  while (antalValdahorn < antalHorn){
		valdPunkt = slumpPunkt();
		valdChar = valdPunkt.getNamn().charAt(0);
		if (!valdaNamn[valdChar - 65]){
		  polylinje.laggTill(valdPunkt);
		  antalValdahorn += 1;
		  valdaNamn[valdChar - 65 ] = true;
		}
	  }
	  //Sätt färg
	  String farg;
	  int fargint = rand.nextInt(3);
	  switch (fargint){
		case 0: farg = "gul";
		  break;
		case 1: farg = "red";
		  break;
		case 2: farg = "blue";
		  break;
		default:farg = "";
		  break;
	  }
	  polylinje.setFarg(farg);
	  return polylinje;
	}




}
