package com.LilGlen.Recipes.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.LilGlen.Recipes.models.Recipe;
import com.LilGlen.Recipes.models.RecipeCategory;
import com.LilGlen.Recipes.repositories.RecipeRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Configuration
public class DataInitializer {

    @Autowired
    private RecipeRepository recipeRepository;

    @Bean
    CommandLineRunner initDatabase() {
        return args -> {
            // Inserir receitas apenas se elas não existirem no banco de dados
            insertRecipeIfNotExists(new Recipe(
                    null, // id será gerado automaticamente
                    "Snack feijão com arroz",
                    "Gabriel Menezes, aluno do curso de gastronomia, 3°semestre",
                    "2 xícaras feijão cozido sem o caldo, 2 xícaras de arroz cozido, 1 ovo, 1/2 xícara de farinha de rosca, Sal e pimenta do reino a gosto, Farinha Panko, Óleo para fritar",
                    "Processe o arroz, feijão, ovo, farinha de rosca, sal e pimenta até formar uma massa. Modele quadradinhos, passe na farinha Panko e frite em óleo aquecido.",
                    "Retire após dourar e coloque sobre um papel toalha. Sirva-o com uma maionese e ou catchup.",
                    RecipeCategory.LANCHES));

            insertRecipeIfNotExists(new Recipe(
                    null,
                    "Peito de Frango Recheado",
                    "Pablo Munhoz, aluno do curso de gastronomia, 2° semestre",
                    "01 filés de peito frango, 1/2 cebola, 02 dentes de alho, 1/2 pimentão verde, 1/2 tomate, Sal e pimenta do reino a gosto, Salsa, cebolinha, manjericão, orégano (opcional), Azeite de oliva, Manteiga a gosto",
                    "Colocar o peito de frango sobre um plástico filme, temperar com sal e pimenta do reino, feche o plástico e reserve. Numa panela, refogue com azeite o alho, a cebola, o pimentão, o tomate. Com uma faca, abra o peito de frango no meio no sentido longitudinal e coloque os temperos refogados.",
                    "Unte uma forma, coloque os peitos já recheados, e cubra com papel alumínio. Leve ao forno a 200°C por aproximadamente, 40min. Retire do forno e coloque para dourar com manteiga numa frigideira. Sirva num prato e polvilhe as ervas por cima do peito de frango.",
                    RecipeCategory.AVES));

            insertRecipeIfNotExists(new Recipe(
                    null,
                    "Frango ao Molho de Mostarda",
                    "Gustavo, aluno do curso de gastronomia, 4° semestre ",
                    "2 peitos de frango, 1 colher de sopa de mostarda Dijon, 1 colher de sopa de manteiga, 1 dente de alho picado, 200ml de creme de leite, Sal e pimenta a gosto.",
                    "Tempere os peitos de frango com sal e pimenta. Em uma frigideira, derreta a manteiga e doure o frango de ambos os lados. Retire o frango e reserve. Na mesma frigideira, refogue o alho e adicione o creme de leite e a mostarda.",
                    "Misture até formar um molho homogêneo. Coloque o frango de volta na frigideira e cozinhe por mais alguns minutos no molho. Sirva com arroz ou legumes.",
                    RecipeCategory.AVES));

            insertRecipeIfNotExists(new Recipe(
                    null,
                    "Bolo de Arroz",
                    "Géssica Bogano, aluna do curso de gastronomia, 1°semestre",
                    "2 e 1/2 xícaras de chá de arroz cozido, 3 ovos médios, 200 ml de leite de coco, 60 ml de óleo, 1 xícara de chá de açúcar, 50g de coco seco ralado, 1 colher de sopa de fermento químico em pó. Para untar: 1 colher de sopa de Manteiga, Farinha de arroz, Açúcar a gosto.",
                    "Preaqueça o forno a 200°C. Unte a forma com a manteiga, salpique a colher de sopa de açúcar, a farinha de arroz e reserve. Em um liquidificador bata os ovos, o arroz cozido, o leite de coco, o óleo e o açúcar, até ficar uma mistura homogênea. Com uma espátula adicione o coco ralado seco e o fermento à mistura, mexendo com cuidado até que tudo fique bem incorporado.",
                    "Transfira a massa para a forma untada e leve ao forno pré-aquecido por cerca de 40 minutos. Verifique se o meio da massa está assado; se sim, pode retirar do forno, esperar esfriar e servir.",
                    RecipeCategory.BOLOS_E_TORTAS));

            insertRecipeIfNotExists(new Recipe(
                    null,
                    "Doce de mamão verde com coco",
                    "Fábia de Jesus, aluna do curso de gastronomia, 3°semestre",
                    "2 mamões grandes, 1 coco seco grande ralado, 1kg de açúcar, Cravo e canela a gosto.",
                    "Lavar os mamões e em seguida cortar as suas pontas, descascar e retirar as sementes; Cortar em cubinhos. Colocar o mamão para ferver, descartar a água. Em uma panela grande colocar todos os ingredientes.",
                    "Deixar cozinhar, mexendo sempre para não grudar no fundo da panela. O ponto é quando desgrudar da panela.",
                    RecipeCategory.DOCES_E_SOBREMESAS));

            insertRecipeIfNotExists(new Recipe(
                    null,
                    "Salpicão da Casca de Melancia",
                    "Leonardo Martins, aluno do curso de gastronomia, 3° semestre",
                    "1/2 melancia, 2 colheres de sopa de azeite, 1 cebola, 1 dente de alho, 1/2 talo de salsão, 1 pimentão, 1/2 de repolho, 1/2 maçã verde, 8 azeitonas, 1 colher de sopa de mostarda, 1 copo de requeijão, 5 colheres de sopa de maionese, 1 limão, Cheiro verde, pimenta do reino e sal a gosto, Batata palha, 1 peito de frango.",
                    "Descascar a melancia e a maçã verde. Retirar a entrecasca da melancia. Refogar o frango na cebola e no alho e acrescentar o pimentão cortado em cubos, juntamente com o cheiro-verde, pimenta do reino e sal.",
                    "Adicionar em outro recipiente a azeitona, a entrecasca da melancia ralada, os talos cortados, o repolho, a mostarda, a maionese e o requeijão. Mistura todos os ingredientes e adiciona a batata palha e sal se precisar.",
                    RecipeCategory.BOLOS_E_TORTAS));

            insertRecipeIfNotExists(new Recipe(
                    null,
                    "Tortilha de Batata e Couve-Flor",
                    "Igor Rafael, aluno do curso de gastronomia, 1° semestre",
                    "1 cebola pequena, 2 ovos médios, 1/2 colher (chá) de sal, 1/4 xícara (chá) de couve-flor lavada e picada, 2 batatas pequenas cortadas em tiras bem finas, 1 colher (sopa) de azeite.",
                    "Descasque e pique a cebola. Bata os ovos em um refratário pequeno, acrescente o sal, a cebola, a couve-flor e misture bem.",
                    "Em uma frigideira, doure a batata no azeite, acrescente a mistura de ovos batidos e frite até que os dois lados fiquem dourados.",
                    RecipeCategory.MASSAS));

            insertRecipeIfNotExists(new Recipe(
                    null,
                    "Panqueca de Cenoura",
                    "Willian da Silva, aluno do curso de gastronomia, 2° semestre",
                    "2 ovos, 1 cenoura picada, 2 xícaras (chá) de leite, 4 colheres (sopa) de óleo, Sal a gosto, 2 xícaras (chá) de farinha de trigo, Óleo para untar, 2 xícaras (chá) de molho de tomate, 1 xícara (chá) de queijo parmesão ralado para polvilhar, Cheiro-verde picado para polvilhar. Recheio: 4 xícaras (chá) de presunto triturado, 1 xícara (chá) de ricota triturada, Sal e pimenta-do-reino a gosto, 1 xícara (chá) de requeijão tipo Catupiry, Cheiro-verde picado a gosto.",
                    "Para a massa, bata no liquidificador os ovos, a cenoura, o leite, o óleo, sal e a farinha até ficarem homogêneos. Aqueça uma frigideira antiaderente em fogo médio, coloque o equivalente a 1 concha pequena de massa e gire para cobrir todo o fundo. Deixe dourar levemente. Vire a massa e doure do outro lado. Proceda da mesma forma com toda a massa. Deixe esfriar.",
                    "Misture os ingredientes do recheio e divida entre as massas. Enrole como rocambole e coloque em um refratário grande, untado com um pouco do molho. Cubra com o molho restante, polvilhe com o queijo parmesão e leve ao forno médio, pré aquecido, por 20 minutos. Polvilhe com cheiro-verde e sirva em seguida.",
                    RecipeCategory.LANCHES));
        };
    }

    private void insertRecipeIfNotExists(Recipe recipe) {
        // Verifica se a receita já existe no banco de dados pelo nome
        recipeRepository.findByNameAndAuthor(recipe.getName(), recipe.getAuthor())
                .ifPresentOrElse(existingRecipe -> {
                    // Receita já existe, não fazer nada
                }, () -> {
                    // Receita não existe, salvar no repositório
                    recipeRepository.save(recipe);
                });

    }
}
