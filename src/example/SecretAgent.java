package example;

class SecretAgent {

    private final String secretName;
    private final int secretNumber;

    public SecretAgent(String secretName, int secretNumber) {
        this.secretName = secretName;
        this.secretNumber = secretNumber;
    }

    public String getSecretName() {
        return secretName;
    }

    public int getSecretNumber() {
        return secretNumber;
    }

    private void emitSecretMessage() {
        System.out.println("No one can print me!");
    }
}