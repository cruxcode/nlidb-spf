public static void symbol_giver(Nodes x, Geneartor genObj, Schema s) {
		String name = x.name;
		String symbol = s.TrackType.get(name);
		if(s!=null){
		    x.symbol = symbol;
		}else{
		    x.symbol = genObj.nextPerm(genObj.last1);
		    genObj.last1 = x.symbol;
		}
		for(int i=0;i<x.children.size();i++) {
			tree_traverser(x.children.get(i),genObj,s);
		}
	}
