package videolocadora.models;

public class Person {
    
    private int idPerson;
    
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


CREATE TABLE pessoas (
    codigo integer NOT NULL,
    data_nascimento date NOT NULL,
    sexo character varying(1) NOT NULL,
    nome d_nome NOT NULL,
    cartao integer NOT NULL,
    numero integer NOT NULL,
    foto character varying(100) NOT NULL,
    telefone_res d_telefone NOT NULL,
    telefone_cel d_telefone NOT NULL,
    telefone_com d_telefone,
    grau_parentesco character varying(15),
    rg character varying(15) NOT NULL,
    e_mail character varying(30),
    cpf character varying(11) NOT NULL,
    tipo integer NOT NULL,
    id_logradouro integer,
    complemento character varying(50),
    CONSTRAINT pessoas_sexo_check CHECK (((sexo)::text = ANY (ARRAY[('M'::character varying)::text, ('F'::character varying)::text])))
);