package figure;

public enum ColorCode {
    //COLOR STATES
    RED, YELLOW, PINK, BLUE, GREEN, GREY;

    //METHODS
    private int Value;
    private void Color(int Value){this.Value=Value;}
    public int color(){return Value;}
    public void setColorRed(){Value=1;}
    public void setColorYellow(){Value=2;}
    public void setColorPink(){Value=3;}
    public void setColorBlue(){Value=4;}
    public void setColorGreen(){Value=5;}
    //

}
