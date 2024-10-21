package org.example;

/**
 * La enumeración {@code tipoReunion} representa los diferentes tipos de reuniones 
 * que pueden clasificarse como técnicas, de marketing o de otro tipo.
 */
public enum tipoReunion {
    /**
     * Reunión técnica, relacionada con aspectos técnicos o de desarrollo.
     */
    TECNICA,
    
    /**
     * Reunión de marketing, relacionada con estrategias de marketing o ventas.
     */
    MARKETING,
    
    /**
     * Otro tipo de reunión no categorizada en técnica o marketing.
     */
    OTRO;

    /**
     * Sobrescribe el método {@code toString} para devolver el nombre del tipo de reunión
     * en letras minúsculas.
     * 
     * @return El nombre del tipo de reunión en minúsculas.
     */
    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
