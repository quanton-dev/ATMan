import Vue from 'vue'
import VueI18n from 'vue-i18n'
import { trTR } from './locale'

Vue.use(VueI18n)

// Create VueI18n instance with options
export const i18n = new VueI18n({
  locale: 'tr_TR',
  messages: {
    tr_TR: trTR
  }
})
