import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WallTest {

    Wall wall;

    @Test
    void findBlockByColorTestShouldReturnEmptyOptionalWhenBlocksIsEmpty(){
        Given:
        wall = new Wall();
        wall.setBlocks(new ArrayList<>());
        Optional<Block> result;
        When:
        result = wall.findBlockByColor("red");
        Then:
        assertEquals(result.isPresent(), false);
    }

    @Test
    void findBlockByColorTestShouldReturnBlockWhenBlocksHaveElementsInColor(){
        Given:
        wall = new Wall();
        List<Block> blocks = new ArrayList<>();
        Block blockRed = new BlockImp("red", "wood");
        Block blockBlue = (new BlockImp("blue", "cotton"));
        Block blockGreen = new BlockImp("green", "glass");

        blocks.add(blockRed);
        blocks.add(blockBlue);
        blocks.add(blockGreen);
        wall.setBlocks(blocks);

        Optional<Block> result;
        When:
        result = wall.findBlockByColor("red");
        Then:
        assertEquals(result.get(), blockRed);
    }

    @Test
    void findBlocksByMaterialTestShouldReturnEmptyListWhenBlocksIsEmpty(){
        Given:
        wall = new Wall();
        wall.setBlocks(new ArrayList<>());
        List<Block> result;
        When:
        result = wall.findBlocksByMaterial("wood");
        Then:
        assertEquals(result.isEmpty(), true);
    }

    @Test
    void findBlocksByMaterialTestShouldReturnOneElementListWhenBlocksHaveElement(){
        Given:
        wall = new Wall();
        List<Block> blocks = new ArrayList<>();
        Block blockRed = new BlockImp("red", "wood");
        Block blockBlue = (new BlockImp("blue", "cotton"));
        Block blockGreen = new BlockImp("green", "glass");

        blocks.add(blockRed);
        blocks.add(blockBlue);
        blocks.add(blockGreen);
        wall.setBlocks(blocks);

        List<Block> result;;
        When:
        result = wall.findBlocksByMaterial("cotton");
        Then:
        assertEquals(result.size(), 1);
        assertEquals(result.get(0), blockBlue);
    }

    @Test
    void findBlocksByMaterialTestShouldReturnManyElementsListWhenBlocksHaveElements(){
        Given:
        wall = new Wall();
        List<Block> blocks = new ArrayList<>();
        Block blockRed = new BlockImp("red", "wood");
        Block blockBlue = (new BlockImp("blue", "cotton"));
        Block blockOrange = (new BlockImp("orange", "cotton"));
        Block blockGreen = new BlockImp("green", "glass");

        blocks.add(blockRed);
        blocks.add(blockBlue);
        blocks.add(blockGreen);
        blocks.add(blockOrange);
        wall.setBlocks(blocks);

        List<Block> result;;
        When:
        result = wall.findBlocksByMaterial("cotton");
        Then:
        assertEquals(result.size(), 2);
        assertEquals(result.contains(blockBlue), true);
        assertEquals(result.contains(blockOrange), true);
    }

    @Test
    void countTestShouldReturn0WhenBlocksIsEmpty(){
        Given:
        wall = new Wall();
        wall.setBlocks(new ArrayList<>());
        int result;
        When:
        result = wall.count();
        Then:
        assertEquals(result, 0);
    }

    @Test
    void countTestShouldReturnNumberOfElementsWhenBlocksIsNotEmpty(){
        Given:
        wall = new Wall();
        List<Block> blocks = new ArrayList<>();
        Block blockRed = new BlockImp("red", "wood");
        Block blockBlue = (new BlockImp("blue", "cotton"));
        Block blockOrange = (new BlockImp("orange", "cotton"));
        Block blockGreen = new BlockImp("green", "glass");

        blocks.add(blockRed);
        blocks.add(blockBlue);
        blocks.add(blockGreen);
        blocks.add(blockOrange);
        wall.setBlocks(blocks);

        int result;
        When:
        result = wall.count();
        Then:
        assertEquals(result, 4);
    }



    private class BlockImp implements Block {

        private String color;
        private String material;

        public BlockImp(String color, String material) {
            this.color = color;
            this.material = material;
        }

        @Override
        public String getColor() {
            return color;
        }

        @Override
        public String getMaterial() {
            return material;
        }
    }
}
