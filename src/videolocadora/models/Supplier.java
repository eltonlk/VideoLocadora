package videolocadora.models;

public class Supplier {
    
    
    
    
}

    id_fornecedor integer NOT NULL,
    numero integer NOT NULL,
    complemento character varying(50),
    telefone1 d_telefone NOT NULL,
    telefone2 d_telefone NOT NULL,
    telefone3 d_telefone,
    telefone4 d_telefone,
    telefone5 d_telefone,
    e_mail character varying(50),
    contato character varying(30) NOT NULL,
    observacoes text,
    fornecedor d_nome NOT NULL,
    cnpj_cpf character varying(14) NOT NULL,
    id_logradouro integer