package sci.smarthome.homework;

/** Abstract class care defineste dispozitivele de timp smart si care implementeaza interfata
 *  Toate dispozitivele pornesc cu un consum de tip stand-by de 0.5
 *  Aceasta clasa are ca si metoda returnarea statusului unui dispozitiv (on/off)
 */

public abstract class HostDevice implements SmartDevice {
    double defaultConsumption = 0.1;
    boolean status;

    public void turnOn() {
        this.status = true;
    }

    public void turnOff() {
        this.status = false;
    }

    public double getConsumption() {
        return status ? defaultConsumption + 5 : defaultConsumption;
    }

    boolean status (){
        return status;
    }
}