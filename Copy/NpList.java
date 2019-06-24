class NpList{
    
    ArrayList<String> np_list = new ArrayList<String>();
    
    public void add_np_list(String value, String col_value, String c_type, String var_type, String pos_tag)
    {
        if(var_type=="category" && pos_tag=="NP")
        {
            String str = value + " :- " + pos_tag + " : " + col_value + ":" + c_type;
            this.np_list.add(str);
        }
    }
}