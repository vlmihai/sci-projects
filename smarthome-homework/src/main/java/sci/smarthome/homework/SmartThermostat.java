package sci.smarthome.homework;

/** Clasa SmartThermostat extinde clasa abstracta si implementeaza interfata.
 *  Comportamentele specifice sunt: reglarea temperaturii.
 */

public class SmartThermostat extends HostDevice {
    private int temperature;

    /** Daca dispozitivul este oprit are consumul clasei parinte (consumul de standby).
     *  Daca este pornit are consum de 5.
     */
    public double getConsumption () {
        double energyConsumption = 5;
        return status ? energyConsumption : defaultConsumption;
    }

    /** Returneaza valoarea temperaturii la care a fost setat termostatul.
     */
    int getTemperature (){
        return temperature;
    }

    /** Seteaza temperatura termostatului.
     * @param temperature
     */
    void setTemperature (int temperature) {
        if (status){
            this.temperature = temperature;
        }
    }
}
