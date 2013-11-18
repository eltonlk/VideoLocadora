package videolocadora.models;

public class Logradouro {
    
}

CREATE TABLE logradouros (
    id_logradouro integer NOT NULL,
    cep character varying(8) NOT NULL,
    num_final integer NOT NULL,
    num_inicial integer NOT NULL,
    logradouro character varying(50) NOT NULL,
    id_bairro integer
);