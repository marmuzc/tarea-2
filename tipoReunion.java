public enum tipoReunion {
    TECNICA, MARKETING, OTRO;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
