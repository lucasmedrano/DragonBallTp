package Superficie;



public abstract class Terreno extends Superficie {

	public static final int VELOCIDAD_TERRENO = 1;
	private String nombre;

	private int pasos_normal;
	private int pasos_t1;
	private int pasos_t2;

	@Override
	public int getPasos_normal() {
		return this.pasos_normal;
	}

	@Override
	public int getPasos_T1() {
		return this.pasos_t1;
	}

	@Override
	public int getPasos_T2(){
		return this.pasos_t2;
	}
	protected void setPasos_normal(int pasos) {
		this.pasos_normal = pasos;
	}

	protected void setPasos_T1(int pasos) {
		this.pasos_t1 = pasos;
	}
	
	protected void setPasos_T2(int pasos){
		this.pasos_t2 = pasos;
	}

	public String devuelveNombreCont() {
		return nombre;
	}

	protected void agregarRutaDeImagen(String nombreDeRuta) {
		this.nombre = nombreDeRuta;
	}
}
