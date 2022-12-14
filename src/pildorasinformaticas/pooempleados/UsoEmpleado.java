package pildorasinformaticas.pooempleados;

import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;

public class UsoEmpleado {
    public static void main(String[] args) {
        Herencia jefe_RRHH = new Herencia("Juan",55000,2006,9,25);
        jefe_RRHH.setIncentivo(2570);
        Empleado [] misEmpleados=new Empleado[6];
        misEmpleados[0]=new Empleado("Federico Suarez",85000,2020,10,19);
        misEmpleados[1]=new Empleado("Ana Lopez",95000,2021,1,18);
        misEmpleados[2]=new Empleado("Maria Martin",80000,2022,8,20);
        misEmpleados[3]=new Empleado("Antonio Fernandez");
        misEmpleados[4]=jefe_RRHH;//Polimorfismo o principio de sustitucion
        misEmpleados[5]=new Herencia("Maria",95000,1999,5,26);
        //Casting para convertir un tipo de objeto en otro
        Herencia jefaFinanzas = (Herencia) misEmpleados[5];
        jefaFinanzas.setIncentivo(55000);


        for(Empleado e:misEmpleados){
            e.subeSueldo(5);
        }

        Arrays.sort(misEmpleados);
        for (Empleado e:misEmpleados) {
            System.out.println("Nombre: " + e.dameNombre() + "\nSueldo: "
                    + e.dameSueldo()
                    + "\nFecha de alta: " + e.dameFechaContrato());
            System.out.println("---------------------------------");
        }

    }
}
//Creamos una nueva clase
class Empleado implements Comparable{

    //Creamos las variables de clase
    private String nombre;
    private double sueldo;
    private Date altaContrato;

    //Creamos un constructor de la clase
    public Empleado(String nombre,double sueldo,int agno,int mes,int dia){
        this.nombre=nombre;
        this.sueldo=sueldo;
        GregorianCalendar calendario=new GregorianCalendar(agno,mes-1,dia);
        altaContrato=calendario.getTime();
    }
    //Creamos otro constructor para realizar sobrecarga de constructores
    public Empleado(String nombre){
        this(nombre,30000,2000,01,01);
    }

    //creamos un getter (devuelve un valor)
    public String dameNombre(){
        return nombre;
    }
    //creamos un getter(devuelve un valor)
    public double dameSueldo(){
        return sueldo;
    }
    //creamos un getter (devuelve un valor)
    public Date dameFechaContrato(){
        return altaContrato;
    }
    //creamos un setter(no devuelve valor)
    public void subeSueldo(double porcentaje){
        double aumento=sueldo*porcentaje/100;
        sueldo+=aumento;
    }

    public int compareTo(Object miObjeto){
        Empleado otroEmpleado = (Empleado) miObjeto;
        if (this.sueldo<otroEmpleado.sueldo){
            return -1;
        }else if(this.sueldo>otroEmpleado.sueldo){
            return 1;
        }else {
            return 0;
        }

    }
}

