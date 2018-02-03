package player.common;

public enum CommonTexts {

    RESUME("Você já assistiu parte deste vídeo, o que deseja fazer?\n" +
            "Assistir do início\n" +
            "Continuar assistindo", "You have watched part of this video before. What do you want to do?\n" +
            "Watch from the beginning\n" +
            "Resume video", "¿Ya has visto parte de este vídeo, que quieres hacer?\n" +
            "Ver desde el inicio\n" +
            "Seguir viendo"),
    GEOBLOCK("Este conteúdo não está disponível na sua localização.", "This content is not available in your location.", "Este contenido no está disponible en su localización."),
    LEAD("Informe seus dados para entrarmos em contato\n" +
            "Seus dados são confidenciais e não serão publicados\n" +
            "Enviar", "Informe seus dados para entrarmos em contato\n" +
            "Seus dados são confidenciais e não serão publicados\n" +
            "Submit", "Informe seus dados para entrarmos em contato\n" +
            "Seus dados são confidenciais e não serão publicados\n" +
            "Envíe"),
    SHARING("Compartilhar vídeo", "Share video", "Compartir el vídeo"),
    DISPUBLED("Ops! Este vídeo não está\n" +
            "mais disponível.\n" +
            "Desculpe-nos", "Oops! This video is no\n +" +
            "longer available.\n" +
            "Sorry", "¡Ops! Este video no se\n" +
            "encuentra disponible.\n" +
            "Disculpe"),
    DOMAIN_RESTRICTION("Ops! Você não possui permissão\n" +
            "para assistir este vídeo.\n" +
            "Desculpe-nos", "Oops! You do not have permission\n" +
            "to watch this video.\n" +
            "Sorry",
            "¡Ops! Usted no tiene permiso\n" +
                    "para asistir este video.\n" +
                    "Disculpe"),
    BACK_LIVE("Voltar para a transmissão ao vivo.", "Skip ahead to live broadcast.", "Volver a la transmisión en vivo.");


    private String PT;
    private String EN;
    private String ES;

    CommonTexts(String PT, String EN, String ES) {
        this.PT = PT;
        this.EN = EN;
        this.ES = ES;
    }

    public String getPT() {
        return PT;
    }

    public String getEN() {
        return EN;
    }

    public String getES() {
        return ES;
    }


    public String getLanguage(String language) {
        switch (language) {
            case "EN":
                return getEN();
            case "ES":
                return getES();
            default:
                return getPT();
        }

    }

}
