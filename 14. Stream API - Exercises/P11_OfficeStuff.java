import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by todor on 16.10.2017 г..
 */
public class P11_OfficeStuff {
    public static void main(String[] args) throws IOException {
        TreeMap<String, LinkedHashMap<String, Integer>> companiesAndProducts = getCompaniesAndProducts();
        
        printCompany(companiesAndProducts);
    }
    
    private static void printCompany(TreeMap<String, LinkedHashMap<String, Integer>> companiesAndProducts) {
        for (Map.Entry<String, LinkedHashMap<String, Integer>> company : companiesAndProducts.entrySet()){
            System.out.printf("%s: ", company.getKey());
            System.out.println(company.getValue().toString().replaceAll("[{}]", "").replaceAll("=", "-"));
        }
    }
    
    private static TreeMap<String, LinkedHashMap<String, Integer>> getCompaniesAndProducts() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputsCount = Integer.parseInt(br.readLine());
        
        TreeMap<String, LinkedHashMap<String, Integer>> companiesAndProducts = new TreeMap<>();
        
        for (int i = 0; i < inputsCount; i++) {
            String[] input = Arrays.stream(br.readLine().split("[\\|-]"))
                    .filter(s -> !s.isEmpty())
                    .map(s -> s.trim())
                    .toArray(String[]::new);
            String company = input[0];
            String product = input[2];
            Integer quantity = Integer.valueOf(input[1]);
            companiesAndProducts.putIfAbsent(company, new LinkedHashMap<>());
            companiesAndProducts.get(company).putIfAbsent(product, 0);
            Integer previousQuantity = companiesAndProducts.get(company).get(product);
            companiesAndProducts.get(company).put(product, previousQuantity + quantity);
        }
        
        return companiesAndProducts;
    }
}
