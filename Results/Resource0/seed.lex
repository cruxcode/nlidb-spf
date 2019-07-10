//Testing: plural
//states :- NP/PP : (lambda $0:<e,t> (a:<<e,t>,e> (lambda $1:e (and:<t*,t> (state:<s,t> $1) ($0 $1)))))
//states :- NP : (a:<<e,t>,e> (lambda $0:e (state:<s,t> $0)))
//states :- NP\(N/N) : (lambda $0:<<e,t>,<e,t>> (a:<<e,t>,e> ($0 (lambda $1:e (state:<s,t> $1)))))

//wh-words
show :- S/N : (lambda $0:<e,t> $0)
what :- S/(S\NP)/N : (lambda $0:<e,t> (lambda $1:<e,t> (lambda $2:e (and:<t*,t> ($0 $2) ($1 $2)))))
what :- S/(S/NP)/N : (lambda $0:<e,t> (lambda $1:<e,t> (lambda $2:e (and:<t*,t> ($0 $2) ($1 $2)))))
how many :- S/(S\NP)/N : (lambda $0:<e,t> (lambda $1:<e,t> (count:<<e,t>,i> (lambda $2:e (and:<t*,t> ($0 $2) ($1 $2)))))
how many :- S/(S/NP)/N : (lambda $0:<e,t> (lambda $1:<e,t> (count:<<e,t>,i> (lambda $2:e (and:<t*,t> ($0 $2) ($1 $2)))))
how many :- S/(S\NP)/N : (lambda $0:<e,t> (lambda $1:<e,t> (count:<<e,t>,i> (lambda $2:e (and:<t*,t> ($0 $2) ($1 $2)))))
how many :- S/(S/NP)/N : (lambda $0:<e,t> (lambda $1:<e,t> (count:<<e,t>,i> (lambda $2:e (and:<t*,t> ($0 $2) ($1 $2)))))
//how many :- S/N : (lambda $0:<e,t> (count:<<e,t>,i> $0))
which :- S/NP : (lambda $0:e $0)
how many :- S/NP : (lambda $0:e $0)
how :- S/NP : (lambda $0:e $0)
what :- S/NP : (lambda $0:e $0)
//where :- S/NP : (lambda $0:e (lambda $1:e (loc:<lo,<lo,t>> $0 $1)))

// <e,t> nouns

// <e,i> nouns


// active verb


// passive verb - Texas has Austin
 
//contains :- (S\NP)/NP : (lambda $0:e (lambda $1:e (loc:<lo,<lo,t>> $0 $1)))  

//preposition


//adjective


// for eliptical sentences such as "states bordering texas"

number :- S/N : (lambda $0:<e,t> (count:<<e,t>,i> $0))
// for "sentences" such as "population of seattle"
population :- S/NP : (lambda $0:e (population:<lo,i> $0))

//determiners
the :- N/N : (lambda $0:<e,t> $0)
is :- N/N : (lambda $0:<e,t> $0)
a :- N/N : (lambda $0:<e,t> $0)
of :- N/N : (lambda $0:<e,t> $0)
the :- NP/NP : (lambda $0:e $0)
is :- NP/NP : (lambda $0:e $0)
of :- NP/NP : (lambda $0:e $0)
the :- NP/N : (lambda $0:<e,t> (the:<<e,t>,e> $0))

that :- PP/(S\NP) : (lambda $0:<e,t> $0)
that :- PP/(S/NP) : (lambda $0:<e,t> $0)
which :- PP/(S\NP) : (lambda $0:<e,t> $0)
which :- PP/(S/NP) : (lambda $0:<e,t> $0)
are :- PP/PP : (lambda $0:<e,t> $0)

// for "state with the capital des moines"
with the :- PP/(S\NP) : (lambda $0:<e,t> $0)

//




//
// for "populations of the states .."


// for "what is the population of seattle"


// copula, etc.
are :- (N\N)/N : (lambda $0:<e,t> (lambda $1:<e,t> (lambda $2:e (and:<t*,t> ($0 $2) ($1 $2)))))
are :- (S\NP)/PP : (lambda $0:<e,t> $0)
does :- (S/NP)/(S/NP) : (lambda $0:<e,t> $0)
does :- (S\NP)/(S\NP) : (lambda $0:<e,t> $0)
// what state is dallas in
//is :- ((S\NP)/(PP/NP))/NP : (lambda $0:e (lambda $1:<e,<e,t>> (lambda $2:e ($1 $2 $0))))
is :- (S/NP)/(S/NP) : (lambda $0:<e,t> $0)
have :- (S/NP)/(S/NP) : (lambda $0:<e,t> $0)
is :- (S\NP)/(S\NP) : (lambda $0:<e,t> $0)
are there :- S\NP : (lambda $0:e true:t)
is :- (S\NP)/NP : (lambda $0:e (lambda $1:e (equals:<e,<e,t>> $1 $0)))

// negation
not :- N/N : (lambda $0:<e,t> (lambda $1:e (not:<t,t> ($0 $1))))
not :- PP/PP : (lambda $0:<e,t> (lambda $1:e (not:<t,t> ($0 $1))))
do not :- (S\NP)/(S\NP) : (lambda $0:<e,t> (lambda $1:e (not:<t,t> ($0 $1))))
no :- (S\NP)/(S\NP) : (lambda $0:<e,t> (lambda $1:e (not:<t,t> ($0 $1))))
excluding :- PP/NP : (lambda $0:e (lambda $1:e (not:<t,t> (equals:<e,<e,t>> $1 $0))))
//no :- (S\NP)\(S\NP/NP)/N : (lambda $0:<e,t> (lambda $1:<e,<e,t>> (lambda $2:e (not:<t,t> ($1 (a:<<e,t>,e> $0) $2)))))

// empty sentence modifier
tell me :- S/S : (lambda $0:<e,t> $0)
can you  :- S/S : (lambda $0:<e,t> $0)
please  :- S/S : (lambda $0:<e,t> $0)
please :- S\S : (lambda $0:e $0)
please :- S\S : (lambda $0:t $0)
in feet :- S\S : (lambda $0:e $0)
in meters :- S\S : (lambda $0:e $0)
is :- S/S : (lambda $0:t $0)




border :- (S\NP)/NP : (lambda $0:e (lambda $1:e (next_to:<b_pkey,<s_pkey,t>> $0 $1)))
border :- (S\NP)/NP : (lambda $0:e (lambda $1:e (next_to:<s_pkey,<b_pkey,t>> $0 $1)))
border :- (S\NP)/NP : (lambda $0:e (lambda $1:e (next_to:<b_pkey,<s_pkey,t>> $1 $0)))
border :- (S\NP)/NP : (lambda $0:e (lambda $1:e (next_to:<s_pkey,<b_pkey,t>> $1 $0)))
border :- NP/NP : (lambda $0:e (next_to:<b_pkey,s_pkey> $0))


states :- (S\NP)/NP : (lambda $0:e (lambda $1:e (next_to:<b_pkey,<s_pkey,t>> $1 $0)))
states :- NP/PP : (lambda $0:<e,t> (lambda $1:e (next_to:<b_pkey,<t,s_pkey>> $1 ($0 $1))))
states :- NP/(S\NP) : (lambda $0:<e,t> (lambda $1:e (next_to:<b_pkey,<t,s_pkey>> $1 ($0 $1))))

maharashtra :- NP : (pkey_retriever:<s,s_pkey> maharashtra:s)
the maharashtra :- NP : (pkey_retriever:<s,s_pkey> maharashtra:s)
the state of haryana :- NP : (pkey_retriever:<s,s_pkey> haryana:s)
maharashtra state :- NP : (pkey_retriever:<s,s_pkey> maharashtra:s)
haryana :- NP : (pkey_retriever:<s,s_pkey> haryana:s)
the maharashtra :- NP : (pkey_retriever:<s,s_pkey> maharashtra:s)
the state of haryana :- NP : (pkey_retriever:<s,s_pkey> haryana:s)
maharashtra state :- NP : (pkey_retriever:<s,s_pkey> maharashtra:s)
madhya pradesh :- NP : (pkey_retriever:<s,s_pkey> madhya_pradesh:s)
the maharashtra :- NP : (pkey_retriever:<s,s_pkey> maharashtra:s)
the state of haryana :- NP : (pkey_retriever:<s,s_pkey> haryana:s)
maharashtra state :- NP : (pkey_retriever:<s,s_pkey> maharashtra:s)
rajasthan :- NP : (pkey_retriever:<s,s_pkey> rajasthan:s)
the maharashtra :- NP : (pkey_retriever:<s,s_pkey> maharashtra:s)
the state of haryana :- NP : (pkey_retriever:<s,s_pkey> haryana:s)
maharashtra state :- NP : (pkey_retriever:<s,s_pkey> maharashtra:s)
jharkhand :- NP : (pkey_retriever:<s,s_pkey> jharkhand:s)
the maharashtra :- NP : (pkey_retriever:<s,s_pkey> maharashtra:s)
the state of haryana :- NP : (pkey_retriever:<s,s_pkey> haryana:s)
maharashtra state :- NP : (pkey_retriever:<s,s_pkey> maharashtra:s)
uttar pradesh :- NP : (pkey_retriever:<s,s_pkey> uttar_pradesh:s)
the maharashtra :- NP : (pkey_retriever:<s,s_pkey> maharashtra:s)
the state of haryana :- NP : (pkey_retriever:<s,s_pkey> haryana:s)
maharashtra state :- NP : (pkey_retriever:<s,s_pkey> maharashtra:s)
uttrakhand :- NP : (pkey_retriever:<s,s_pkey> uttrakhand:s)
the maharashtra :- NP : (pkey_retriever:<s,s_pkey> maharashtra:s)
the state of haryana :- NP : (pkey_retriever:<s,s_pkey> haryana:s)
maharashtra state :- NP : (pkey_retriever:<s,s_pkey> maharashtra:s)
bihar :- NP : (pkey_retriever:<s,s_pkey> bihar:s)
the maharashtra :- NP : (pkey_retriever:<s,s_pkey> maharashtra:s)
the state of haryana :- NP : (pkey_retriever:<s,s_pkey> haryana:s)
maharashtra state :- NP : (pkey_retriever:<s,s_pkey> maharashtra:s)
aurangabad :- NP : (pkey_retriever:<c,c_pkey> aurangabad:c)
the aurangabad :- NP : (pkey_retriever:<c,c_pkey> aurangabad:c)
city named mumbai :- NP : (pkey_retriever:<c,c_pkey> mumbai:c)
mumbai :- NP : (pkey_retriever:<c,c_pkey> mumbai:c)
the aurangabad :- NP : (pkey_retriever:<c,c_pkey> aurangabad:c)
city named mumbai :- NP : (pkey_retriever:<c,c_pkey> mumbai:c)
jalgaon :- NP : (pkey_retriever:<c,c_pkey> jalgaon:c)
the aurangabad :- NP : (pkey_retriever:<c,c_pkey> aurangabad:c)
city named mumbai :- NP : (pkey_retriever:<c,c_pkey> mumbai:c)
bhusawal :- NP : (pkey_retriever:<c,c_pkey> bhusawal:c)
the aurangabad :- NP : (pkey_retriever:<c,c_pkey> aurangabad:c)
city named mumbai :- NP : (pkey_retriever:<c,c_pkey> mumbai:c)
nagpur :- NP : (pkey_retriever:<c,c_pkey> nagpur:c)
the aurangabad :- NP : (pkey_retriever:<c,c_pkey> aurangabad:c)
city named mumbai :- NP : (pkey_retriever:<c,c_pkey> mumbai:c)
kurukshetra :- NP : (pkey_retriever:<c,c_pkey> kurukshetra:c)
the aurangabad :- NP : (pkey_retriever:<c,c_pkey> aurangabad:c)
city named mumbai :- NP : (pkey_retriever:<c,c_pkey> mumbai:c)
gurgaon :- NP : (pkey_retriever:<c,c_pkey> gurgaon:c)
the aurangabad :- NP : (pkey_retriever:<c,c_pkey> aurangabad:c)
city named mumbai :- NP : (pkey_retriever:<c,c_pkey> mumbai:c)
chandigarh :- NP : (pkey_retriever:<c,c_pkey> chandigarh:c)
the aurangabad :- NP : (pkey_retriever:<c,c_pkey> aurangabad:c)
city named mumbai :- NP : (pkey_retriever:<c,c_pkey> mumbai:c)
ranchi :- NP : (pkey_retriever:<c,c_pkey> ranchi:c)
the aurangabad :- NP : (pkey_retriever:<c,c_pkey> aurangabad:c)
city named mumbai :- NP : (pkey_retriever:<c,c_pkey> mumbai:c)
deoghar :- NP : (pkey_retriever:<c,c_pkey> deoghar:c)
the aurangabad :- NP : (pkey_retriever:<c,c_pkey> aurangabad:c)
city named mumbai :- NP : (pkey_retriever:<c,c_pkey> mumbai:c)
kanpur :- NP : (pkey_retriever:<c,c_pkey> kanpur:c)
the aurangabad :- NP : (pkey_retriever:<c,c_pkey> aurangabad:c)
city named mumbai :- NP : (pkey_retriever:<c,c_pkey> mumbai:c)
noida :- NP : (pkey_retriever:<c,c_pkey> noida:c)
the aurangabad :- NP : (pkey_retriever:<c,c_pkey> aurangabad:c)
city named mumbai :- NP : (pkey_retriever:<c,c_pkey> mumbai:c)
luckhnow :- NP : (pkey_retriever:<c,c_pkey> luckhnow:c)
the aurangabad :- NP : (pkey_retriever:<c,c_pkey> aurangabad:c)
city named mumbai :- NP : (pkey_retriever:<c,c_pkey> mumbai:c)
kota :- NP : (pkey_retriever:<c,c_pkey> kota:c)
the aurangabad :- NP : (pkey_retriever:<c,c_pkey> aurangabad:c)
city named mumbai :- NP : (pkey_retriever:<c,c_pkey> mumbai:c)
jaipur :- NP : (pkey_retriever:<c,c_pkey> jaipur:c)
the aurangabad :- NP : (pkey_retriever:<c,c_pkey> aurangabad:c)
city named mumbai :- NP : (pkey_retriever:<c,c_pkey> mumbai:c)
jodhpur :- NP : (pkey_retriever:<c,c_pkey> jodhpur:c)
the aurangabad :- NP : (pkey_retriever:<c,c_pkey> aurangabad:c)
city named mumbai :- NP : (pkey_retriever:<c,c_pkey> mumbai:c)
bhopal :- NP : (pkey_retriever:<c,c_pkey> bhopal:c)
the aurangabad :- NP : (pkey_retriever:<c,c_pkey> aurangabad:c)
city named mumbai :- NP : (pkey_retriever:<c,c_pkey> mumbai:c)
khandwa :- NP : (pkey_retriever:<c,c_pkey> khandwa:c)
the aurangabad :- NP : (pkey_retriever:<c,c_pkey> aurangabad:c)
city named mumbai :- NP : (pkey_retriever:<c,c_pkey> mumbai:c)
katni :- NP : (pkey_retriever:<c,c_pkey> katni:c)
the aurangabad :- NP : (pkey_retriever:<c,c_pkey> aurangabad:c)
city named mumbai :- NP : (pkey_retriever:<c,c_pkey> mumbai:c)
reewa :- NP : (pkey_retriever:<c,c_pkey> reewa:c)
the aurangabad :- NP : (pkey_retriever:<c,c_pkey> aurangabad:c)
city named mumbai :- NP : (pkey_retriever:<c,c_pkey> mumbai:c)
dehradun :- NP : (pkey_retriever:<c,c_pkey> dehradun:c)
the aurangabad :- NP : (pkey_retriever:<c,c_pkey> aurangabad:c)
city named mumbai :- NP : (pkey_retriever:<c,c_pkey> mumbai:c)
rishikesh :- NP : (pkey_retriever:<c,c_pkey> rishikesh:c)
the aurangabad :- NP : (pkey_retriever:<c,c_pkey> aurangabad:c)
city named mumbai :- NP : (pkey_retriever:<c,c_pkey> mumbai:c)
nainital :- NP : (pkey_retriever:<c,c_pkey> nainital:c)
the aurangabad :- NP : (pkey_retriever:<c,c_pkey> aurangabad:c)
city named mumbai :- NP : (pkey_retriever:<c,c_pkey> mumbai:c)
mussoorie :- NP : (pkey_retriever:<c,c_pkey> mussoorie:c)
the aurangabad :- NP : (pkey_retriever:<c,c_pkey> aurangabad:c)
city named mumbai :- NP : (pkey_retriever:<c,c_pkey> mumbai:c)
patna :- NP : (pkey_retriever:<c,c_pkey> patna:c)
the aurangabad :- NP : (pkey_retriever:<c,c_pkey> aurangabad:c)
city named mumbai :- NP : (pkey_retriever:<c,c_pkey> mumbai:c)
darbhanga :- NP : (pkey_retriever:<c,c_pkey> darbhanga:c)
the aurangabad :- NP : (pkey_retriever:<c,c_pkey> aurangabad:c)
city named mumbai :- NP : (pkey_retriever:<c,c_pkey> mumbai:c)
aurangabad :- NP : (pkey_retriever:<c,c_pkey> aurangabad:c)
the aurangabad :- NP : (pkey_retriever:<c,c_pkey> aurangabad:c)
city named mumbai :- NP : (pkey_retriever:<c,c_pkey> mumbai:c)


// quantifier
largest :- NP/N : (lambda $0:<e,t> (argmax:<<e,t>,<<e,i>,e>> $0 size:<lo,i>))
largest :- NP/N/PP : (lambda $0:<e,e> (lambda $1:<e,t> (lambda $2:<e,t> (argmax:<<e,t>,<<e,i>,e>> (lambda $3:e (and:<t*,t> ($1 $3) ($2 $3))) size:<lo,i>))))
smallest :- NP/N : (lambda $0:<e,t> (argmin:<<e,t>,<<e,i>,e>> $0 size:<lo,i>))
smallest :- NP/N/PP : (lambda $0:<e,i> (lambda $1:<e,t> (lambda $2:<e,t> (argmin:<<e,t>,<<e,i>,e>> (lambda $3:e (and:<t*,t> ($1 $3) ($2 $3))) size:<lo,i>))))
//longest :- NP/N : (lambda $0:<e,t> (argmax:<<e,t>,<<e,i>,e>> $0 len:<r,i>))
//shortest :- NP/N : (lambda $0:<e,t> (argmin:<<e,t>,<<e,i>,e>> $0 len:<r,i>))
highest :- NP/N : (lambda $0:<e,t> (argmax:<<e,t>,<<e,i>,e>> $0 elevation:<lo,i>))
lowest :- NP/N : (lambda $0:<e,t> (argmin:<<e,t>,<<e,i>,e>> $0 elevation:<lo,i>))
is :- (NP\N)/(NP/N)  : (lambda $0:<<e,t>,e> $0)
are  :- (NP\N)/(NP/N)  : (lambda $0:<<e,t>,e> $0)
with  :- (NP\N)/(NP/N)  : (lambda $0:<<e,t>,e> $0)

// what is the most populated state
most :- (NP/N)/N : (lambda $0:<e,e> (lambda $1:<e,t> (argmax:<<e,t>,<<e,i>,e>> $1 $0)))
highest :- (NP/N)/N : (lambda $0:<e,e> (lambda $1:<e,t> (argmax:<<e,t>,<<e,i>,e>> $1 $0)))
biggest :- (NP/N)/N : (lambda $0:<e,e> (lambda $1:<e,t> (argmax:<<e,t>,<<e,i>,e>> $1 $0)))
largest :- (NP/N)/N : (lambda $0:<e,e> (lambda $1:<e,t> (argmax:<<e,t>,<<e,i>,e>> $1 $0)))
largest :- (NP/N)/PP/N : (lambda $0:<e,e> (lambda $1:<e,t> (lambda $2:<e,t> (argmax:<<e,t>,<<e,i>,e>> (lambda $3:e (and:<t*,t> ($1 $3) ($2 $3))) $0))))
lowest :- (NP/N)/N : (lambda $0:<e,e> (lambda $1:<e,t> (argmin:<<e,t>,<<e,i>,e>> $1 $0)))
sparsest :- (NP/N)/N : (lambda $0:<e,e> (lambda $1:<e,t> (argmin:<<e,t>,<<e,i>,e>> $1 $0)))
smallest :- (NP/N)/N : (lambda $0:<e,e> (lambda $1:<e,t> (argmin:<<e,t>,<<e,i>,e>> $1 $0)))
smallest :- (NP/N)/PP/N : (lambda $0:<e,e> (lambda $1:<e,t> (lambda $2:<e,t> (argmin:<<e,t>,<<e,i>,e>> (lambda $3:e (and:<t*,t> ($1 $3) ($2 $3))) $0))))
least :- (NP/N)/N : (lambda $0:<e,e> (lambda $1:<e,t> (argmin:<<e,t>,<<e,i>,e>> $1 $0)))
// largest city by population
largest :- (NP/N)/N : (lambda $0:<e,t> (lambda $1:<e,e> (argmax:<<e,t>,<<e,i>,e>> $0 $1)))
by :- N/N : (lambda $0:<e,e> $0)

// area of all of the states combined
combined :- (NP\N)\N : (lambda $0:<e,t> (lambda $1:<e,e> (sum:<<e,t>,<<e,i>,i>> $0 $1)))
// total population of ...
total :- (NP/N)/N : (lambda $0:<e,e> (lambda $1:<e,t> (sum:<<e,t>,<<e,i>,i>> $1 $0)))

// what river traverses the most states
the most :- NP\N\(S\NP/NP)/N : (lambda $0:<e,t> (lambda $1:<e,<e,t>> (lambda $2:<e,t> (argmax:<<e,t>,<<e,i>,e>> $2 (lambda $3:e (count:<<e,t>,i> (lambda $4:e (and:<t*,t> ($0 $4) ($1 $4 $3)))))))))
most :- NP\N\(S\NP/NP)/N : (lambda $0:<e,t> (lambda $1:<e,<e,t>> (lambda $2:<e,t> (argmax:<<e,t>,<<e,i>,e>> $2 (lambda $3:e (count:<<e,t>,i> (lambda $4:e (and:<t*,t> ($0 $4) ($1 $4 $3)))))))))
fewest :- NP\N\(S\NP/NP)/N : (lambda $0:<e,t> (lambda $1:<e,<e,t>> (lambda $2:<e,t> (argmin:<<e,t>,<<e,i>,e>> $2 (lambda $3:e (count:<<e,t>,i> (lambda $4:e (and:<t*,t> ($0 $4) ($1 $4 $3)))))))))
least :- NP\N\(S\NP/NP)/N : (lambda $0:<e,t> (lambda $1:<e,<e,t>> (lambda $2:<e,t> (argmin:<<e,t>,<<e,i>,e>> $2 (lambda $3:e (count:<<e,t>,i> (lambda $4:e (and:<t*,t> ($0 $4) ($1 $4 $3)))))))))
the least :- NP\N\(S\NP/NP)/N : (lambda $0:<e,t> (lambda $1:<e,<e,t>> (lambda $2:<e,t> (argmin:<<e,t>,<<e,i>,e>> $2 (lambda $3:e (count:<<e,t>,i> (lambda $4:e (and:<t*,t> ($0 $4) ($1 $4 $3)))))))))

the most :- NP\N\(PP/NP)/N : (lambda $0:<e,t> (lambda $1:<e,<e,t>> (lambda $2:<e,t> (argmax:<<e,t>,<<e,i>,e>> $2 (lambda $3:e (count:<<e,t>,i> (lambda $4:e (and:<t*,t> ($0 $4) ($1 $4 $3)))))))))
most :- NP\N\(PP/NP)/N : (lambda $0:<e,t> (lambda $1:<e,<e,t>> (lambda $2:<e,t> (argmax:<<e,t>,<<e,i>,e>> $2 (lambda $3:e (count:<<e,t>,i> (lambda $4:e (and:<t*,t> ($0 $4) ($1 $4 $3)))))))))
fewest :- NP\N\(PP/NP)/N : (lambda $0:<e,t> (lambda $1:<e,<e,t>> (lambda $2:<e,t> (argmin:<<e,t>,<<e,i>,e>> $2 (lambda $3:e (count:<<e,t>,i> (lambda $4:e (and:<t*,t> ($0 $4) ($1 $4 $3)))))))))
least :- NP\N\(PP/NP)/N : (lambda $0:<e,t> (lambda $1:<e,<e,t>> (lambda $2:<e,t> (argmin:<<e,t>,<<e,i>,e>> $2 (lambda $3:e (count:<<e,t>,i> (lambda $4:e (and:<t*,t> ($0 $4) ($1 $4 $3)))))))))
the least :- NP\N\(PP/NP)/N : (lambda $0:<e,t> (lambda $1:<e,<e,t>> (lambda $2:<e,t> (argmin:<<e,t>,<<e,i>,e>> $2 (lambda $3:e (count:<<e,t>,i> (lambda $4:e (and:<t*,t> ($0 $4) ($1 $4 $3)))))))))

// higher than, etc.
higher than :- PP/NP : (lambda $0:e (lambda $1:e (>:<i,<i,t>> (elevation:<lo,i> $1) (elevation:<lo,i> $0))))
//lower than :- PP\N/NP : (lambda $0:e (lambda $1:e (>:<i,<i,t>> (elevation:<lo,i> $1) (elevation:<lo,i> $0))))
at least one :- (S\NP)\(S\NP/NP)/N : (lambda $0:<e,t> (lambda $1:<e,<e,t>> (lambda $2:e (>:<i,<i,t>> (count:<<e,t>,i> (lambda $3:e (and:<t*,t> ($0 $3) ($1 $3 $2)))) 0:i))))

