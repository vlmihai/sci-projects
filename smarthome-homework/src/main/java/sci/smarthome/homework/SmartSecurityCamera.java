package sci.smarthome.homework;

/** Clasa SmartSecurityCamera extinde clasa abstracta si implementeaza interfata.
 *  Comportamentele specifice sunt: start/stop filming.
 */

public class SmartSecurityCamera extends HostDevice {
    private boolean recording;

    /** Daca dispozitivul este oprit are consumul clasei parinte (consumul de standby).
     *  Daca este pornit are consum de 7.
     */
    public double getConsumption () {
        double energyConsumption = 7;
        return status ? energyConsumption : defaultConsumption;
    }

    /** Returneaza daca dispozitivul inregistreaza sau nu.
     */
    boolean isRecording (){
        return recording;
    }

    /** Porneste/opreste inregistrarea.
     * @param recording
     */
    void setRecording (boolean recording) {
        if (status){
            this.recording = recording;
        } else {
            this.recording = false;
        }
    }
}
