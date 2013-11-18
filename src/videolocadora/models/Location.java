package videolocadora.models;

public class Location {
    
    private int idLocation;
    
    
    
}

    id_cre integer NOT NULL,
    data_hora_devolucao timestamp without time zone NOT NULL,
    status character varying(1) NOT NULL,
    data_hora_locacao timestamp without time zone NOT NULL,
    data_vencimento date NOT NULL,
    valor d_moeda NOT NULL,
    forma_pagamento integer,
    juros d_moeda,
    multa d_moeda,
    desconto d_moeda,
    data_pagamento date,
    codigo integer,
    codigo_barra integer