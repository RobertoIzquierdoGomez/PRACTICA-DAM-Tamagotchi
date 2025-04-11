package Proyectos.Tamagotchi;

import java.util.Scanner;

public class principal {

    //Funcion para el menu prinicpal
    public static void menuPrincipal(){
        System.out.println("\n************* Bienvenido al menú principal *************");
        System.out.println("\n\t(1) - Crear mascota (Maximo 3)");
        System.out.println("\t(2) - Cuidar mascota");
        System.out.println("\t(3) - Eliminar mascota");
        System.out.println("\t(0) - Salir");
        System.out.print("\nElige una de las opciones: ");
    }

    //Funcion para el menu de mascota
    public static void menuMascota(String mascota){
        System.out.println("************* Estás en el menú de mascota de " + mascota + ". *************");
        System.out.println("\n\t(1) - Alimentar a tú mascota");
        System.out.println("\t(2) - Jugar con tú mascota");
        System.out.println("\t(3) - Mandar a descansar a tú mascota");
        System.out.println("\t(4) - Mostrar estado de tú mascota");
        System.out.println("\t(0) - Elegir otra mascota");
        System.out.print("\nElige una de las opciones: ");
    }

    //Funcion de seleccion de mascota
    public static void seleccionMascota(Perro[] perro) {
        System.out.println("\n************* Menú de selección de mascota *************");
        for (int i = 0; i < perro.length; i++) {
            if (perro[i] == null || perro[i].getNombre() == null) {
                System.out.println("\t(" + (i + 1) + ") - Vacío");
            } else {
                System.out.println("\t(" + (i + 1) + ") - " + perro[i].getNombre());
            }
        }
        System.out.println("\t(0) - Atrás");
        System.out.print("\nElige un hueco de mascota: ");
    }

    //Funcion para crear la mascota
    public static void crearMascota(Perro[] perro, int i){
        Scanner sc = new Scanner(System.in);
        if (perro[i].getNombre() == null){
            System.out.print("\nIntroduce un nombre para tu mascota: ");
            perro[i].setNombre(sc.next());
            System.out.print("\nIntorudce la edad de tu mascota: ");
            perro[i].setEdad(introducirNumero());
            if(perro[i].getEstadoAnimo().equals("MUERTO")){
                perro[i].setEstadoAnimo("Feliz");
                perro[i].setNivelEnergia(100);
                perro[i].setNivelHambre(-100);
            }
        } else {
            System.out.println("\nERROR: no puedes elegir un hueco con una mascota existente");
        }
    }

    //Funcion submenu crear mascota
    public static void submenuAccionCrearMascota(Perro [] perro, int opcion){
        switch (opcion) {
            case 1 -> {
                crearMascota(perro, opcion - 1);
            }
            case 2 -> {
                crearMascota(perro, opcion - 1);
            }
            case 3 -> {
                crearMascota(perro, opcion - 1);
            }
            case 0 -> opcion = 0;
            default -> System.out.println("ERROR: Elige una de las opciones");
        }
    }
    //Funcion submenu selección mascota para el cuidado
    public static void submenuSeleccionCuidado(Perro [] perro,int mascotaSeleccionada, int opcion){
        switch (opcion) {
            case 1 -> {
                if(perro[mascotaSeleccionada - 1].getNombre() == null){
                    System.out.println("ERROR: No puedes elegir un hueco vacío. Debes crear antes una mascota");
                } else {
                    menuMascota(perro[mascotaSeleccionada - 1].getNombre());
                    opcion = introducirNumero();
                    submenuAccionCuidarMascota(perro, mascotaSeleccionada,opcion);
                }
            }
            case 2 -> {
                if(perro[mascotaSeleccionada - 1].getNombre() == null){
                    System.out.println("ERROR: No puedes elegir un hueco vacío. Debes crear antes una mascota");
                } else {
                    menuMascota(perro[mascotaSeleccionada - 1].getNombre());
                    opcion = introducirNumero();
                    submenuAccionCuidarMascota(perro, mascotaSeleccionada,opcion);
                }
            }
            case 3 -> {
                if(perro[mascotaSeleccionada - 1].getNombre() == null){
                    System.out.println("ERROR: No puedes elegir un hueco vacío. Debes crear antes una mascota");
                } else {
                    menuMascota(perro[mascotaSeleccionada - 1].getNombre());
                    opcion = introducirNumero();
                    submenuAccionCuidarMascota(perro, mascotaSeleccionada,opcion);
                }
            }
            default ->System.out.println("ERROR: Elige una de las opciones");
        }
    }

    //Funcion submenu cuidar mascota
    public static void submenuAccionCuidarMascota(Perro[] perro, int mascota, int opcion) {
        boolean control = true;
        while (control) {
            // Verificar si la mascota está muerta antes de cualquier acción
            if (perro[mascota - 1].getEstadoAnimo().equals("MUERTO")) {
                System.out.println("\nTu mascota " + perro[mascota - 1].getNombre() + " ha muerto. Volviendo al menú principal...");
                control = false; // Salir del bucle
                break;
            }
    
            // Realizar la acción seleccionada
            switch (opcion) {
                case 1 -> {
                    perro[mascota - 1].comer();
                }
                case 2 -> {
                    perro[mascota - 1].jugar();
                }
                case 3 -> {
                    perro[mascota - 1].dormir();
                }
                case 4 -> {
                    perro[mascota - 1].mostrarEstado();
                }
                case 0 -> {
                    control = false; // Salir del menú de mascota
                    continue;
                }
                default -> System.out.print("ERROR: Elige una de las opciones: ");
            }
    
            // Verificar si la mascota está muerta después de ejecutar una acción
            if (perro[mascota - 1].getEstadoAnimo().equals("MUERTO")) {
                System.out.println("\nTu mascota " + perro[mascota - 1].getNombre() + " ha muerto. Volviendo al menú principal...");
                perro[mascota - 1].setNombre(null);
                control = false; // Salir del bucle
            } else {
                // Mostrar el menú nuevamente si la mascota sigue viva
                menuMascota(perro[mascota - 1].getNombre());
                opcion = introducirNumero();
            }
        }
    }
    
    //Funcion para validar numero correcto
    public static int introducirNumero(){
        Scanner sc = new Scanner(System.in);
        int numero;
        while(!sc.hasNextInt()){
            System.out.print("\nERROR debes ingresar un número: ");
            sc.next();
        }
        return numero = sc.nextInt();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Variables
        boolean programaEjecucion = true;
        int opcion;

        //Objetos/instancias de perro

        Perro [] perro = {new Perro(), new Perro(), new Perro()};

        do {
            menuPrincipal();
            opcion = introducirNumero();
            switch (opcion) {
                case 1: {
                    seleccionMascota(perro);
                    opcion = introducirNumero();
                    submenuAccionCrearMascota(perro, opcion);
                    break;
                }
                case 2: {
                    seleccionMascota(perro);
                    opcion = introducirNumero();
                    int mascotaSeleccionada = opcion;
                    submenuSeleccionCuidado(perro, mascotaSeleccionada, opcion);
                    break;
                }
                case 3:{
                    seleccionMascota(perro);
                    opcion = introducirNumero();
                    switch (opcion) {
                        case 1 -> {
                            if(perro[opcion - 1].getNombre() != null){
                                perro[opcion - 1].setBorrado();
                            } else {
                                System.out.println("ERROR: ese hueco está vacío");
                            }
                        }
                        case 2 -> {
                            if(perro[opcion - 1].getNombre() != null){
                                perro[opcion - 1].setBorrado();
                            } else {
                                System.out.println("ERROR: ese hueco está vacío");
                            }
                        }
                        case 3 -> {
                            if(perro[opcion - 1].getNombre() != null){
                                perro[opcion - 1].setBorrado();
                            } else {
                                System.out.println("ERROR: ese hueco está vacío");
                            }
                        }

                    }
                    break;
                }
                case 0: {
                    System.out.println("Saliendo del programa...");
                    programaEjecucion = false;
                    break;
                }

                default: System.out.println("ERROR: Elige una de las opciones");
            }

        } while(programaEjecucion);
            
        sc.close();
    }
}
