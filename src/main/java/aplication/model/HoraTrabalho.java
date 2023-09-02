package aplication.model;

public enum HoraTrabalho {
	H0800, H0830, H0900, H0930, H1000, H1030, H1100, H1130, H1300, H1330, H1400, H1430,
    H1500, H1530, H1600, H1630, H1700, H1730, H1800, H1830, H1900;
	
	@Override
    public String toString() {
        return name().replace("H", "").substring(0, 2) + ":" + name().substring(2);
    }
}
