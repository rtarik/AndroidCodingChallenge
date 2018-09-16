package io.github.teeyare.android_coding_challenge.data.network;

import java.util.List;

import io.github.teeyare.android_coding_challenge.data.Product;

/**
 * Created by teeyare (tarik) on 9/16/18.
 */
public class ProductsResponse {
    public static final String MOCK_RESPONSE = " {\n" +
            "     \"data\": [{\n" +
            "             \"itemId\": \"2acf4ac1-4000-4766-91ac-3a0ab47a811c\",\n" +
            "             \"value\": \"100.00\",\n" +
            "             \"currency\": \"CAD\",\n" +
            "             \"title\": \"Item 1\",\n" +
            "             \"description\": {\n" +
            "                 \"en-CA\": \"Lorem ipsum dolor sit amet, consectetur adipiscing elit (EN).\",\n" +
            "                 \"fr-CA\": \"Lorem ipsum dolor sit amet, consectetur adipiscing elit (FR).\"\n" +
            "             }\n" +
            "\n" +
            "         },\n" +
            "         {\n" +
            "             \"itemId\": \"1c2ddcaa-383a-4cc3-a492-9f71c4056076\",\n" +
            "             \"value\": \"125.00\",\n" +
            "             \"currency\": \"USD\",\n" +
            "             \"title\": \"Item 2\",\n" +
            "             \"description\": {\n" +
            "                 \"en-CA\": \"Nullam condimentum, magna eu bibendum faucibus, diam augue commodo est, vitae dictum lorem risus eu nulla (EN).\",\n" +
            "                 \"fr-CA\": \"Nullam condimentum, magna eu bibendum faucibus, diam augue commodo est, vitae dictum lorem risus eu nulla (FR).\"\n" +
            "             }\n" +
            "         },\n" +
            "         {\n" +
            "             \"itemId\": \"83bcc85f-423b-4161-b656-dc7bb53a7127\",\n" +
            "             \"value\": \"999.99\",\n" +
            "             \"currency\": \"CAD\",\n" +
            "             \"title\": \"Item 3\",\n" +
            "             \"description\": {\n" +
            "                 \"en-CA\": \"Fusce ac euismod dolor, at suscipit mauris. Suspendisse potenti (EN).\",\n" +
            "                 \"fr-CA\": \"Fusce ac euismod dolor, at suscipit mauris. Suspendisse potenti (FR).\"\n" +
            "             }\n" +
            "         },\n" +
            "         {\n" +
            "             \"itemId\": \"e5a1986d-5418-46ae-bab7-7a4ef0e1aa69\",\n" +
            "             \"value\": \"72.23\",\n" +
            "             \"currency\": \"USD\",\n" +
            "             \"title\": \"Item 4\",\n" +
            "             \"description\": {\n" +
            "                 \"en-CA\": \"Vestibulum iaculis risus eget risus porttitor, sit amet rhoncus odio tincidunt (EN).\",\n" +
            "                 \"fr-CA\": \"Vestibulum iaculis risus eget risus porttitor, sit amet rhoncus odio tincidunt (FR).\"\n" +
            "             }\n" +
            "         },\n" +
            "         {\n" +
            "             \"itemId\": \"a64593fe-29e3-468d-bfc9-30488c731d6a\",\n" +
            "             \"value\": \"123.45\",\n" +
            "             \"currency\": \"CAD\",\n" +
            "             \"title\": \"Item 5\",\n" +
            "             \"description\": {\n" +
            "                 \"en-CA\": \"Donec vitae hendrerit leo. Integer pretium pharetra orci, sed luctus risus dictum et (EN).\",\n" +
            "                 \"fr-CA\": \"Donec vitae hendrerit leo. Integer pretium pharetra orci, sed luctus risus dictum et (FR).\"\n" +
            "             }\n" +
            "         }\n" +
            "     ]\n" +
            " }";

    private Product[] data;

    public Product[] getData() {
        return data;
    }
}
