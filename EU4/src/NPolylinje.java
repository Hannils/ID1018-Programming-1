import java.util.Iterator;
import java.util.Arrays;

public class NPolylinje implements Polylinje {

  private static class Nod {
	public Punkt horn;
	public Nod nastaNod;

	public Nod(Punkt horn) {
	  this.horn = horn;
	  nastaNod = null;
	}
  }

  private Nod horns;
  private String farg = "svart";
  private int bredd = 1; //pixlar

  public NPolylinje() {
	this.horns = null;
  }

  public NPolylinje(Punkt[] horns) {
	if (horns.length > 0) {
	  Nod nod = new Nod(new Punkt(horns[0]));
	  this.horns = nod;
	  int pos = 1;
	  while (pos < horns.length) {
		nod.nastaNod = new Nod(new Punkt(horns[pos++]));
		nod = nod.nastaNod;
	  }
	}
  }

  public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append("{");
	if (horns != null) {
	  sb.append("[");
	  Nod n = horns;
	  while (n != null) {
		sb.append(n.horn);
		n = n.nastaNod;
	  }
	  sb.append("], ");
	}
	sb.append(this.farg + ", " + this.bredd + "}");
	return sb.toString();

  }

  @Override
  public Punkt[] getHorn() {
	int punkter = 0;
	Nod n = horns;

	while (n != null) {
	  punkter++;
	  n = n.nastaNod;
	}

	Punkt[] c = new Punkt[punkter];
	n = horns;
	for (int i = 0; i < punkter; i++) {
	  c[i] = n.horn;
	  n = n.nastaNod;
	}
	return c;
  }

  @Override
  public String getFarg() {
	return this.farg;
  }

  @Override
  public int getBredd() {
	return this.bredd;
  }

  @Override
  public double langd() {
	int points = 0;
	Nod n = horns;

	while (n != null) {
	  points++;
	  n = n.nastaNod;
	}
	return points;
  }

  @Override
  public void setFarg(String farg) {
	this.farg = farg;
  }

  @Override
  public void setBredd(int bredd) {
	this.bredd = bredd;
  }


  @Override
  public void laggTill(Punkt horn) {
	if (horns == null) {
	  horns = new Nod(horn);
	} else {
	  Nod n = horns;
	  while (n.nastaNod != null) {
		n = n.nastaNod;
	  }

	  n.nastaNod = new Nod(horn);
	}
  }

  @Override
  public void laggTillFramfor(Punkt horn, String hornNamn) {
	Nod n = horns;
	while (n != null) {

	  if (n.nastaNod.horn.getNamn() == hornNamn) {

		Nod buff = n.nastaNod;
		n.nastaNod = new Nod(horn);
		n.nastaNod.nastaNod = buff;

		return;
	  }

	  n = n.nastaNod;
	}
  }

  @Override
  public void taBort(String hornNamn) {
	Nod n = horns;
	while (n != null) {

	  if (n.nastaNod.horn.getNamn() == hornNamn) {

		n.nastaNod = n.nastaNod.nastaNod;

		return;
	  }

	  n = n.nastaNod;
	}
  }

  @Override
  public Iterator<Punkt> iterator() {
	return Arrays.asList(this.getHorn()).iterator();
  }

}
