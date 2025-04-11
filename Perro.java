package Proyectos.Tamagotchi;

public class Perro {
    //Atributos
    private String nombre, estadoAnimo = "Feliz";
    private int edad, nivelEnergia = 100, nivelHambre = 0;

    //Contructor
    public Perro(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
        this.estadoAnimo = "Feliz";
        this.nivelEnergia = 100;
        this.nivelEnergia = 0;
    }

    //Contructor por defecto
    public Perro(){};

    //Métodos
    //Métodos Setter
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }

    public void setNivelEnergia(int nivelEnergia){
        this.nivelEnergia += nivelEnergia;
    }

    public void setNivelHambre(int nivelHambre){
        this.nivelHambre += nivelHambre;
    }

    //Setter para borrado
    public void setBorrado(){
        this.nombre = null;
        this.edad = 0;
        this.estadoAnimo = "Feliz";
        this.nivelEnergia = 100;
        this.nivelHambre = 0;
    }

    public void setEstadoAnimo(){
        if((nivelEnergia <= 70 && nivelEnergia >= 50) && (nivelHambre >= 20 && nivelHambre <= 40)){
            estadoAnimo = "Feliz";
        } else if (nivelHambre >= 50 && nivelHambre < 100){
            estadoAnimo = "Hambriento";
        } else if (nivelEnergia < 50 && nivelEnergia > 0){
            estadoAnimo = "Cansado";
        } else if(nivelEnergia == 0 && nivelHambre == 100) {
            estadoAnimo = "MUERTO";
        } else {
            estadoAnimo = "Aburrido";
        }
    }

    public void setEstadoAnimo(String estadoAnimo){
        this.estadoAnimo = estadoAnimo;
    }

    //Metdos Getter
    public String getNombre(){
        return nombre;
    }

    public int getEdad(){
        return edad;
    }

    public String getEstadoAnimo(){
        return estadoAnimo;
    }

    //Metodo para alimentar mascota
    public void comer(){
        if(nivelHambre == 0 || nivelHambre - 10 < 0){
            nivelHambre = 0;
        } else {
            nivelHambre -= 10;
        }
        setEstadoAnimo();
        mostrarEstado();
    }

    //Metodo para jugar con la mascota
    public void jugar(){
        if (nivelHambre == 100 || nivelHambre + 5 > 100) {
            nivelHambre = 100;
        } else {
            nivelHambre += 5;
        }

        if(nivelEnergia == 0 || nivelEnergia - 10 < 0){
            nivelEnergia = 0;
        } else {
            nivelEnergia -= 10;
        }
        setEstadoAnimo();
        mostrarEstado();
    }

    //Metod para dormir
    public void dormir(){
        if(nivelEnergia == 100 || nivelEnergia + 10 > 100){
            nivelEnergia = 100;
        } else {
            nivelEnergia += 10;
        }
        setEstadoAnimo();
        mostrarEstado();
    }

    //Metodo para mostrar las estadisticas de la mascota
    public void mostrarEstado(){
        if(this.nivelEnergia - 5 < 0){
            this.nivelEnergia = 0;
        } else {
            setNivelEnergia(-5);
        }
        if(this.nivelHambre + 5 > 100){
            this.nivelHambre = 100;
        } else {
            setNivelHambre(+5);
        }
        setEstadoAnimo();
        if(!estadoAnimo.equals("MUERTO")){
            System.out.println("Nombre: " + nombre);
            System.out.println("Edad: " + edad);
            System.out.println("Energía: " + nivelEnergia);
            System.out.println("Hambre: " + nivelHambre);
            System.out.println("Estado: " + estadoAnimo);
        }
        
    }
}
