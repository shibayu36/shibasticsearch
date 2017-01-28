package org.shibayu36.shibasticsearch.tokenizer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class NGramTokenizerTest {

  @Test
  public void test2GramTokenize() throws Exception {
    String text = "私はenglishを習います。";
    NGramTokenizer tokenizer = new NGramTokenizer(text, 2);
    assertThat(tokenizer.hasNext()).isTrue().as("最初なら次が存在");
    assertThat(tokenizer.next()).isEqualTo("私は");
    assertThat(tokenizer.next()).isEqualTo("はe");
    assertThat(tokenizer.next()).isEqualTo("en");
    assertThat(tokenizer.next()).isEqualTo("ng");
    assertThat(tokenizer.next()).isEqualTo("gl");
    assertThat(tokenizer.next()).isEqualTo("li");
    assertThat(tokenizer.next()).isEqualTo("is");
    assertThat(tokenizer.next()).isEqualTo("sh");
    assertThat(tokenizer.next()).isEqualTo("hを");
    assertThat(tokenizer.next()).isEqualTo("を習");
    assertThat(tokenizer.next()).isEqualTo("習い");
    assertThat(tokenizer.next()).isEqualTo("いま");
    assertThat(tokenizer.next()).isEqualTo("ます");
    assertThat(tokenizer.next()).isEqualTo("す。");
    assertThat(tokenizer.next()).isEqualTo("。");
    assertThat(tokenizer.hasNext()).isFalse().as("最後までたどりついたのでfalse");
  }

  @Test
  public void test3GramTokenize() throws Exception {
    String text = "englishを習う";
    NGramTokenizer tokenizer = new NGramTokenizer(text, 3);
    assertThat(tokenizer.hasNext()).isTrue().as("最初なら次が存在");
    assertThat(tokenizer.next()).isEqualTo("eng");
    assertThat(tokenizer.next()).isEqualTo("ngl");
    assertThat(tokenizer.next()).isEqualTo("gli");
    assertThat(tokenizer.next()).isEqualTo("lis");
    assertThat(tokenizer.next()).isEqualTo("ish");
    assertThat(tokenizer.next()).isEqualTo("shを");
    assertThat(tokenizer.next()).isEqualTo("hを習");
    assertThat(tokenizer.next()).isEqualTo("を習う");
    assertThat(tokenizer.next()).isEqualTo("習う");
    assertThat(tokenizer.next()).isEqualTo("う");
    assertThat(tokenizer.hasNext()).isFalse().as("最後までたどりついたのでfalse");
  }
}