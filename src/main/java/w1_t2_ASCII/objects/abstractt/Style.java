package w1_t2_ASCII.objects.abstractt;

public abstract class Style {
    public String HORIZONTAL_LINE;
    public String VERTICAL_LINE;
    public String U_L_CORNER;
    public String U_R_CORNER;
    public String D_L_CORNER;
    public String D_R_CORNER;

    public Style(String hLine, String vLine, String ul, String ur, String dl, String dr) {
        this.HORIZONTAL_LINE = hLine;
        this.VERTICAL_LINE = vLine;
        this.U_L_CORNER = ul;
        this.U_R_CORNER = ur;
        this.D_L_CORNER = dl;
        this.D_R_CORNER = dr;
    }
}
