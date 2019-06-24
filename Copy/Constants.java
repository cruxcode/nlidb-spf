class Constants{
    
    ArrayList<String> consts = new ArrayList<String>();
    
    public void add_const(String value, String c_type, String var_type)
    {
        if(var_type=="category")
        {
            String str = value + ":" + c_type;
            this.consts.add(str);
        }
    }
}