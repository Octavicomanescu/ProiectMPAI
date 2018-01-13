
package problema_1;

public class Sensor {

	private DoorContext door1;
	private DoorContext door2;
	private VentilationContext fan;
	private SecuritySysContext sec;
	private LightsContext lumLiving;
	private SysVideoContext camHol;
	private SysVideoContext camIntrare;
	private SenzorFumContext senFumDormitor;
	private CurentElectricContext prizeBucatarie;

	public Sensor() {
		door1 = new DoorContext("intrare");
		door2 = new DoorContext("balcon");
		fan = new VentilationContext("caldura");
		sec = new SecuritySysContext();
		lumLiving = new LightsContext("living");
		camHol = new SysVideoContext();
		senFumDormitor = new SenzorFumContext("dormitor");
		prizeBucatarie = new CurentElectricContext("bucatarie");
	}

	State doorLckd = new DoorLocked();
	State doorUnlckd = new DoorUnlocked();
	State fanOn = new VentilationOn();
	State fanOff = new VentilationOff();
	State secOn = new SecSysOn();
	State secOff = new SecSysOff();
	State lightsOn = new LightsOn();
	State lightsOff = new LightsOff();
	State camOn = new SysVideoOn();
	State camOff = new SysVideoOff();
	State senFumOn = new SenzorFumOn();
	State senFumOff = new SenzorFumOff();
	State curentOn = new CurrElectricOn();
	State curentOff = new CurrElectricOff();

	public String doorLocked() {
		door1.setState(doorLckd);
		return door1.doAction();
	}

	public String doorUnlocked() {
		door2.setState(doorUnlckd);
		return door2.doAction();
	}

	public String fanOn() {
		fan.setState(fanOn);
		return fan.doAction();
	}

	public String fanOff() {
		fan.setState(fanOff);
		return fan.doAction();
	}

	public String SecurityOn() {
		sec.setState(secOn);
		return sec.doAction();
	}

	public String SecurityOff() {
		sec.setState(secOff);
		return sec.doAction();
	}

	public String LightsOn() {
		lumLiving.setState(lightsOn);
		return lumLiving.doAction();
	}

	public String LightsOff() {
		lumLiving.setState(lightsOff);
		return lumLiving.doAction();
	}

	public String CameraOn() {
		camHol.setState(camOn);
		return camHol.doAction();
	}

	public String CameraOff() {
		camIntrare.setState(camOff);
		return camIntrare.doAction();
	}

	public String SenzorFumOn() {
		senFumDormitor.setState(senFumOn);
		return senFumDormitor.doAction();
	}

	public String SenzorFumOff() {
		senFumDormitor.setState(senFumOff);
		return senFumDormitor.doAction();
	}

	public String CurrentOn() {
		prizeBucatarie.setState(curentOn);
		return prizeBucatarie.doAction();
	}

	public String CurrentOff() {
		prizeBucatarie.setState(curentOff);
		return prizeBucatarie.doAction();
	}

}
