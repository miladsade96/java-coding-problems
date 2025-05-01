package chapters.one;

import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("all")
public class challenge01 {
    ///  Creating a multiline SQL, JSON, and HTML string
    /// ------------------------------------------------
    /// Consider the following sql multiline string:
    /// UPDATE "public"."office"
    ///  SET ("address_first", "address_second", "phone") =
    ///   (SELECT "public"."employee"."first_name",
    ///           "public"."employee"."last_name", ?
    ///    FROM "public"."employee"
    ///    WHERE "public"."employee"."job_title" = ?

    public static String beforeJdk8() {
        return "UPDATE \"public\".\"office\"\n"
                + "SET (\"address_first\", \"address_second\", \"phone\") =\n"
                + "  (SELECT \"public\".\"employee\".\"first_name\",\n"
                + "          \"public\".\"employee\".\"last_name\", ?\n"
                + "   FROM \"public\".\"employee\"\n"
                + "   WHERE \"public\".\"employee\".\"job_title\" = ?";
    }

    public static String beforeJdk8UsingStringBuilder() {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE \"public\".\"office\"\n");
        sb.append("SET (\"address_first\", \"address_second\", \"phone\") =\n");
        sb.append("  (SELECT \"public\".\"employee\".\"first_name\",\n");
        sb.append("          \"public\".\"employee\".\"last_name\", ?\n");
        sb.append("   FROM \"public\".\"employee\"\n");
        sb.append("   WHERE \"public\".\"employee\".\"job_title\" = ?");
        return sb.toString();
    }

    public static String usingJdk8() {
        return String.join(
                "\n",
                "UPDATE \"public\".\"office\"",
                "SET (\"address_first\", \"address_second\", \"phone\") =",
                "  (SELECT \"public\".\"employee\".\"first_name\",",
                "          \"public\".\"employee\".\"last_name\", ?",
                "   FROM \"public\".\"employee\"",
                "   WHERE \"public\".\"employee\".\"job_title\" = ?"
        );
    }

    public static String usingJdk8WithStringJoiner() {
        StringJoiner sj = new StringJoiner("\n");
        sj.add("UPDATE \"public\".\"office\"");
        sj.add("SET (\"address_first\", \"address_second\", \"phone\") =");
        sj.add("  (SELECT \"public\".\"employee\".\"first_name\",");
        sj.add("          \"public\".\"employee\".\"last_name\", ?");
        sj.add("   FROM \"public\".\"employee\"");
        sj.add("   WHERE \"public\".\"employee\".\"job_title\" = ?");
        return sj.toString();
    }

    public static String usingJdk8WithStreamApi() {
        return Stream.of(
                "UPDATE \"public\".\"office\"",
                "SET (\"address_first\", \"address_second\", \"phone\") =",
                "  (SELECT \"public\".\"employee\".\"first_name\",",
                "          \"public\".\"employee\".\"last_name\", ?",
                "   FROM \"public\".\"employee\"",
                "   WHERE \"public\".\"employee\".\"job_title\" = ?"
        ).collect(Collectors.joining(String.valueOf("\n")));
    }

    public static String usingJdk13And15WithTextBlocks() {
        return """
                UPDATE "public"."office"
                SET ("address_first", "address_second", "phone") =
                  (SELECT "public"."employee"."first_name",
                          "public"."employee"."last_name", ?
                   FROM "public"."employee"
                   WHERE "public"."employee"."job_title" = ?
                """;
    }

    public static String creatingMultilineJsonUsingTextBlocks() {
        return """
                {
                    "name": "John Doe",
                    "age": 30,
                    "address": {
                        "street": "123 Main St",
                        "city": "Anytown",
                        "state": "CA"
                    },
                    "phoneNumbers": [
                        {
                            "type": "home",
                            "number": "555-555-5555"
                        },
                        {
                            "type": "work",
                            "number": "555-555-5556"
                        }
                    ]
                }
                """;
    }

    public static String creatingMultilineHtmlUsingTextBlocks() {
        return """
                <html>
                    <head>
                        <title>Sample HTML</title>
                    </head>
                    <body>
                        <h1>Hello, World!</h1>
                        <p>This is a sample HTML document.</p>
                    </body>
                </html>
                """;
    }

    public static void main(String[] args) {
        System.out.println("Before JDK 8:\n");
        System.out.println(beforeJdk8());
        System.out.println("*".repeat(100));

        System.out.println("Before JDK 8 using StringBuilder:\n");
        System.out.println(beforeJdk8UsingStringBuilder());
        System.out.println("*".repeat(100));

        System.out.println("Using JDK 8:\n");
        System.out.println(usingJdk8());
        System.out.println("*".repeat(100));

        System.out.println("Using JDK 8 with StringJoiner:\n");
        System.out.println(usingJdk8WithStringJoiner());
        System.out.println("*".repeat(100));

        System.out.println("Using JDK 8 with Stream API:\n");
        System.out.println(usingJdk8WithStreamApi());
        System.out.println("*".repeat(100));

        System.out.println("Using JDK 13 and 15 with Text Blocks:\n");
        System.out.println(usingJdk13And15WithTextBlocks());
        System.out.println("*".repeat(100));

        System.out.println("Creating Multiline JSON using Text Blocks:\n");
        System.out.println(creatingMultilineJsonUsingTextBlocks());
        System.out.println("*".repeat(100));

        System.out.println("Creating Multiline HTML using Text Blocks:\n");
        System.out.println(creatingMultilineHtmlUsingTextBlocks());
        System.out.println("*".repeat(100));
    }
}
