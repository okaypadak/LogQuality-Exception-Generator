module JavaAgent {
    opens dev.padak; // Paketin içeri açılması
    requires java.sql;
    exports dev.padak; // Paketin dışarı açılması
}