package trabalhoa3;

// Definição da superclasse ContatosExtras
class ContatosExtras {
    // Declaração dos atributos privados da classe ContatosExtras
    private String telefone;
    private String cep;

    // Construtor da classe ContatosExtras
    public ContatosExtras(String telefone, String cep) {
        this.telefone = telefone;
        this.cep = cep;
    }

    // Métodos getters para obter os valores dos atributos telefone e endereco.

    // Método getter para obter o telefone.
    public String getTelefone() {
        return telefone; // Retorna o valor de telefone.
    }

    // Método setter para definir o telefone.
    public void setTelefone(String telefone) {
        this.telefone = telefone; // Define o valor de telefone.
    }

    // Método getter para obter o endereco.
    public String getCep() {
        return cep; // Retorna o valor de endereco.
    }

    // Método setter para definir o endereco.
    public void setCep(String cep) {
        this.cep = cep; // Define o valor de endereco.
    }
}

// Definição da classe Funcionario que herda da superclasse ContatosExtras
class Funcionario extends ContatosExtras {
    // Declaração dos atributos privados da classe Funcionario
    private String apelido;
    private String cargo;
    private String salario;
    private int pin;
    private String email;

    // Construtor da classe Funcionario
    public Funcionario(String apelido, String cargo, String salario, int pin, String email, String telefone, String cep) {
        // Chamada ao construtor da superclasse ContatosExtras
        super(telefone, cep);

        /*
        * A seguir temos a atribuição do valor do parâmetro ao atributo da classe.
        * O uso do this.parâmetro é necessário para distinguir o atributo da classe do parâmetro com o mesmo nome.
        */
        this.apelido = apelido;
        this.cargo = cargo;
        this.salario = salario;
        this.pin = pin;
        this.email = email;
    }

    // Métodos getters e setters para os atributos específicos da classe Funcionario...

    // Método getter para obter o apelido do funcionário.
    public String getApelido() {
        return apelido; // Retorna o valor de apelido.
    }

    // Método setter para definir o apelido do funcionário.
    public void setApelido(String apelido) {
        this.apelido = apelido; // Define o valor de apelido.
    }

    // Método getter para obter o cargo do funcionário.
    public String getCargo() {
        return cargo; // Retorna o valor de cargo.
    }

    // Método setter para definir o cargo do funcionário.
    public void setCargo(String cargo) {
        this.cargo = cargo; // Define o valor de cargo.
    }

    // Método getter para obter o salário do funcionário.
    public String getSalario() {
        return salario; // Retorna o valor de salario.
    }

    // Método setter para definir o salário do funcionário.
    public void setSalario(String salario) {
        this.salario = salario; // Define o valor de salario.
    }

    // Método getter para obter o PIN do funcionário.
    public int getPin() {
        return pin; // Retorna o valor de pin.
    }

    // Método setter para definir o PIN do funcionário.
    public void setPin(int pin) {
        this.pin = pin; // Define o valor de pin.
    }

    // Método getter para obter o Email do funcionário.
    public String getEmail() {
        return email; // Retorna o valor de email.
    }

    // Método setter para definir o Email do funcionário.
    public void setEmail(String email) {
        this.email = email; // Define o valor de email.
    }
}
