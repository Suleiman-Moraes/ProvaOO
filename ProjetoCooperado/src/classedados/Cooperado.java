package classedados;
public class Cooperado {
    //Atributos
    private String nomeDoCooperado = "";
    private String profissaoDoCooperado = "";
    private float numerosDeHorasTrabalhadasNoMes = 0;
    private float valorDaHoraDeTrabalho = 0;
    
    //Construtor
    public Cooperado(){}
    public Cooperado(String nome, String profissao, float numero, float valor) throws Exception{
        nomeDoCooperado = nome;
        profissaoDoCooperado = profissao;
        numerosDeHorasTrabalhadasNoMes = numero;
        valorDaHoraDeTrabalho = valor;
        
        if(this.valorDaHoraDeTrabalho < 0) throw new Exception ("Valor da hora de trabalho não pode ser negativo.");
        if(this.valorDaHoraDeTrabalho == 0) throw new Exception ("Valor da hora de trabalho não pode ser 'zero'.");
        if(this.numerosDeHorasTrabalhadasNoMes <= 160) throw new Exception ("Número de horas trabalhadas não podem ser inferior à '160 horas'.");
    }
    public Cooperado(String nome, float numero, float valor) throws Exception{
        nomeDoCooperado = nome;
        profissaoDoCooperado = "";
        numerosDeHorasTrabalhadasNoMes = numero;
        valorDaHoraDeTrabalho = valor;
        
        if(this.valorDaHoraDeTrabalho < 0) throw new Exception ("Valor da hora de trabalho não pode ser negativo.");
        if(this.valorDaHoraDeTrabalho == 0) throw new Exception ("Valor da hora de trabalho não pode ser 'zero'.");
        if(this.numerosDeHorasTrabalhadasNoMes <= 160) throw new Exception ("Número de horas trabalhadas não podem ser inferior à '160 horas'.");
    }
    public Cooperado(Cooperado obj) throws Exception{
        nomeDoCooperado = obj.nomeDoCooperado;
        profissaoDoCooperado = obj.profissaoDoCooperado;
        numerosDeHorasTrabalhadasNoMes = obj.numerosDeHorasTrabalhadasNoMes;
        valorDaHoraDeTrabalho = obj.valorDaHoraDeTrabalho;
        
        if(this.valorDaHoraDeTrabalho < 0) throw new Exception ("Valor da hora de trabalho não pode ser negativo.");
        if(this.valorDaHoraDeTrabalho == 0) throw new Exception ("Valor da hora de trabalho não pode ser 'zero'.");
        if(this.numerosDeHorasTrabalhadasNoMes <= 160) throw new Exception ("Número de horas trabalhadas não podem ser inferior à '160 horas'.");
    }
    
    //Metodos

    public String getNomeDoCooperado() {
        return nomeDoCooperado;
    }

    public String getProfissaoDoCooperado() {
        return profissaoDoCooperado;
    }

    public float getNumerosDeHorasTrabalhadasNoMes() {
        return numerosDeHorasTrabalhadasNoMes;
    }

    public float getValorDaHoraDeTrabalho() {
        return valorDaHoraDeTrabalho;
    }

    public void setNomeDoCooperado(String nomeDoCooperado) {
        this.nomeDoCooperado = nomeDoCooperado;
    }

    public void setProfissaoDoCooperado(String profissaoDoCooperado) {
        this.profissaoDoCooperado = profissaoDoCooperado;
    }

    public void setNumerosDeHorasTrabalhadasNoMes(float numerosDeHorasTrabalhadasNoMes) throws Exception{
        this.numerosDeHorasTrabalhadasNoMes = numerosDeHorasTrabalhadasNoMes;
        if(this.numerosDeHorasTrabalhadasNoMes <= 160) throw new Exception ("Número de horas trabalhadas não podem ser inferior à '160 horas'."); 
    }

    public void setValorDaHoraDeTrabalho(float valorDaHoraDeTrabalho) throws Exception{
        this.valorDaHoraDeTrabalho = valorDaHoraDeTrabalho;
        if(this.valorDaHoraDeTrabalho < 0) throw new Exception ("Valor da hora de trabalho não pode ser negativo.");
        if(this.valorDaHoraDeTrabalho == 0) throw new Exception ("Valor da hora de trabalho não pode ser 'zero'.");
    }
    
    public float caucularSalarioLiquido(){
        return (float)((numerosDeHorasTrabalhadasNoMes * valorDaHoraDeTrabalho) + caucularBonificacao());
    }
    
    public float caucularBonificacao(){
        int bom = 0;
        if(profissaoDoCooperado.toLowerCase().equals("enfermeiro") && profissaoDoCooperado.toLowerCase().equals("dentista")){
            if(numerosDeHorasTrabalhadasNoMes < 250) bom = 0;
            else if(250 <= numerosDeHorasTrabalhadasNoMes && numerosDeHorasTrabalhadasNoMes < 400) bom = 19;
            else bom = 23;
        }
        else{
            if(numerosDeHorasTrabalhadasNoMes < 300) bom = 0;
            else if(300 <= numerosDeHorasTrabalhadasNoMes && numerosDeHorasTrabalhadasNoMes < 500) bom = 20;
            else bom = 25;
        }
        return (float)((numerosDeHorasTrabalhadasNoMes * valorDaHoraDeTrabalho) * (bom/100.0));
    }
    
    public int caucularContribuicao(){
        if(profissaoDoCooperado.toLowerCase().equals("advogado")) return 10;
        else if(profissaoDoCooperado.toLowerCase().equals("engenheiro")) return 9;
        else if(profissaoDoCooperado.toLowerCase().equals("enfermeiro")) return 7;
        else if(profissaoDoCooperado.toLowerCase().equals("dentista")) return 8;
        else return 11;//medico
    }
    
    public float caucularSalarioFinal(){
        
        return (float)((caucularContribuicao()/-100.0 +1) * caucularSalarioLiquido());
    }
}
