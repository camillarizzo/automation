package player.common;

public enum TestCaseEnv {

    AUDIO_LIVE("206", "225?env_id=3"),
    AUDIO_VOD("205", "227?env_id=3"),
    BACKUP_LIVE("192", "210?env_id=3"),
    CAPTION("208", "223?env_id=3"),
    CAST("199", "217?env_id=3"),
    ENABLE_CONTROLS("200", "218?env_id=3"),
    AUTOMATIC_FULLSCREEN("201","219?env_id=3"),
    DISABLE_FULLSCREEN("202", "220?env_id=3"),
    GEOBLOCK_AUDIO("207", "226?env_id=3"),
    GEOBLOCK_LIVE("195", "214?env_id=3"),
    GEOBLOCK_VOD("228", "213?env_id=3"),
    LEAD_PRE("209", "224?env_id=3"),
    LIVE_AD("193", "212?env_id=3"),
    LIVE_DVR("194", "211?env_id=3"),
    DISPUBLED_MEDIA("197", "215?env_id=3"),
    DOMAIN_RESTRICTION("198", "216?env_id=3"),
    RESUME_START("203", "221?env_id=3"),
    RESUME_CONTINUE("203", "221?env_id=3"),
    SHARED("204", "222?env_id=3");

    private String qa;
    private String staging;

    TestCaseEnv(String qa, String staging) {
        this.qa = qa;
        this.staging = staging;
    }

    public String getQa() {
        return qa;
    }

    public String getStaging() {
        return staging;
    }

    public String getCase(String env) {
        if ("STAGING".equals(env))
            return getStaging();
        else
            return getQa();
    }

}
