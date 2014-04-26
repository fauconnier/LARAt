package melodi.internal;

public class Token {
	
	String surface;
	String lem;
	String pos;
	String morpho;
	String head;
	String id;

	String dep;
	
	public Token(){
		this.surface="";
		this.lem="";
		this.pos="";
		this.morpho="";
		this.head="";
		this.id="";
	}
	
	public String getId(){
		return id;
	}
	
	public void setId(String id){
		this.id=id;
	}
	
	@Override
	public String toString() {
		return "		Token " + id + " [surface=" + surface + ", lem=" + lem + ", pos=" + pos
				+ ", morpho=" + morpho + ", head=" + head + ", dep=" + dep
				+ "]\n";
	}
	
	public String getSurface() {
		return surface;
	}

	public void setSurface(String surface) {
		this.surface = surface;
	}

	public String getLem() {
		return lem;
	}

	public void setLem(String lem) {
		this.lem = lem;
	}

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public String getMorpho() {
		return morpho;
	}

	public void setMorpho(String morpho) {
		this.morpho = morpho;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

}
