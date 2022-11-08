package bases;


public class Tempo {

	private static int tempoEsperaMenu = 1;
	private static int tempoEspera = 5;
	private static int tempoEsperaCampo = 5;	
	private static int tempoWait = 15;
	private static int tempoEsperaConsulta = 120;
	private static int tempoRelatorio = 600;
	private static int tempoEsperaAnexarRegistro = 40;
	private static int tempoEsperaMudancaAba = 40;
	private static int tempoEsperaConfirmacao = 50;
	private static int tempoEsperaRetornar = 40;
	private static int tempoEsperaDelete = 40;
	private static int tempoGreak = 100;	
	private static int tempoEsperaReload = 60;
//	private static Logger logger = Logger.getLogger(Tempo.class);
	
	
	
	public static int getTempoEsperaCampo() {
		return tempoEsperaCampo;
	}
	public static void setTempoEsperaCampo(int tempoEsperaCampo) {
		Tempo.tempoEsperaCampo = tempoEsperaCampo;
	}
	
	public static int getTempoBreak() {
		return tempoGreak;
	}
	public static void setTempoBreak(int tempoGreak) {
		Tempo.tempoGreak = tempoGreak;
	}
	/**
	 * @param
	 * @return the tempoEspera
	 */
	public static int getTempoEspera() {
		return tempoEspera;
	}
	public static int getTempoEsperaDelete() {
		return tempoEsperaDelete;
	}
	
	public static int getTempoWait(){
		return tempoWait;
	}
	
	public static int getTempoEsperaReload(){
		return tempoEsperaReload;
	}
	
	public static int getTempoEsperaMenu(){
		return tempoEsperaMenu;
	}
	
	public static int getTempoEsperaRetornar(){
		return tempoEsperaRetornar;
	}
	
	public static int getTempoEsperaAnexarRegistro(){
		return tempoEsperaAnexarRegistro;
	}
	
	public static int getTempoEsperaConfirmacao(){
		return tempoEsperaConfirmacao;
	}
	
	public static int  getTempoEsperaConsulta(){
		return tempoEsperaConsulta;
	}
	
	
	public static int getTempoEsperaRelatorio(){
		return tempoRelatorio;
	}
	
	public static void setTempoEsperaMenu(int tempoEsperaMenu){
		Tempo.tempoEsperaMenu = tempoEsperaMenu;
	}
	
	public static void setTempoEsperaRelatorio(int tempoRelatorio){
		Tempo.tempoRelatorio = tempoRelatorio;
	}
	
	public static void setTempoEspera(int tempoEspera) {
		Tempo.tempoEspera = tempoEspera;
	}
	
	public static void setTempoWait(int tempoWait) {
		Tempo.tempoWait = tempoWait;
	}
	
	public static void setTempoEsperaConsulta(int tempoConsulta){
		Tempo.tempoEsperaConsulta = tempoConsulta; 
	}
	
	public static void setTempoEsperaAnexarRegistro(int tempoEsperaAnexarRegistro) {	
		Tempo.tempoEsperaAnexarRegistro = tempoEsperaAnexarRegistro;	
	}
	
	public static void setTempoEsperaConfirmacao(int tempoEsperaConfirmacao) {
		Tempo.tempoEsperaConfirmacao = tempoEsperaConfirmacao;
	}
	
	public static void setTempoEsperaRetornar(int tempoEsperaRetornar) {
		Tempo.tempoEsperaRetornar = tempoEsperaRetornar;
	
	}
	
	public static void setTempoEsperaReload(int tempoEsperaReload) {
		Tempo.tempoEsperaReload = tempoEsperaReload;
	}
	
	public static void setTempoEsperaDelete(int tempoEsperaDelete) {
		Tempo.tempoEsperaDelete = tempoEsperaDelete;
	}
	
	/**
	 * @return the tempoEsperaMudancaAba
	 */
	public static int getTempoEsperaMudancaAba() {
		return tempoEsperaMudancaAba;
	}

	public static void setTempoEsperaMudancaAba(int tempoEsperaMudancaAba) {
		
	 Tempo.tempoEsperaMudancaAba = tempoEsperaMudancaAba;		
		
	}	
	
	public static void main(String[] args) {
		int tempo = getTempoEspera();
		System.out.println(tempo);
	}
	
	
	
}