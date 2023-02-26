import React, { useState } from "react";
import {
  RiFacebookFill,
  RiInstagramLine,
  RiTwitterFill,
  RiYoutubeFill,
  RiMenuFill,
  RiCloseFill,
} from "react-icons/ri";

const Header = () => {
  const [showMenu, setShowMenu] = useState(false);

  return (
    <header className="text-gray-500 py-4 md:px-20 flex items-center w-full p-4 justify-between bg-black">
      {/*Nav Menu*/}
      <button
        onClick={() => setShowMenu(!showMenu)}
        className="w-1/12 text-2xl"
      >
        <RiMenuFill />
      </button>
      <div
        className={`fixed left-0 top-0 bg-black w-1/2 h-full md:w-1/4 transition-all z-50 ${
          showMenu ? "left-0" : "-left-full"
        }`}
      >
        <button className="text-3xl p-4" onClick={() => setShowMenu(!showMenu)}>
          <RiCloseFill />
        </button>
        <ul className="">
          <li>
            <a
              href="#"
              className="text-2xl block text-center hover:text-[#ff010b] transition-colors p-4"
            >
              Locales
            </a>
          </li>
          <li>
            <a
              href="#"
              className="text-2xl block text-center hover:text-[#ff010b] transition-colors p-4"
            >
              Nacionales
            </a>
          </li>
          <li>
            <a
              href="#"
              className="text-2xl block text-center hover:text-[#ff010b] transition-colors p-4"
            >
              Interior
            </a>
          </li>
          <li>
            <a
              href="#"
              className="text-2xl block text-center hover:text-[#ff010b] transition-colors p-4"
            >
              Policiales
            </a>
          </li>
          <li>
            <a
              href="#"
              className="text-2xl block text-center hover:text-[#ff010b] transition-colors p-4"
            >
              Deportes
            </a>
          </li>
          <li>
            <a
              href="#"
              className="text-2xl block text-center hover:text-[#ff010b] transition-colors p-4"
            >
              Cultura
            </a>
          </li>
        </ul>
        <hr className="h-px my-10 bg-[#ff010b] border-0" />
        <div className="">
          <ul className="flex justify-between mx-2 gap-4 sm:mx-4">
            <li>
              <a
                href="https://facebook.com/"
                className="text-3xl hover:text-[#ff010b] transition-colors"
              >
                <RiFacebookFill />
              </a>
            </li>
            <li>
              <a
                href="https://facebook.com/"
                className="text-3xl hover:text-[#ff010b] transition-colors"
              >
                <RiInstagramLine />
              </a>
            </li>
            <li>
              <a
                href="https://facebook.com/"
                className="text-3xl hover:text-[#ff010b] transition-colors"
              >
                <RiTwitterFill />
              </a>
            </li>
            <li>
              <a
                href="https://facebook.com/"
                className="text-3xl hover:text-[#ff010b] transition-colors"
              >
                <RiYoutubeFill />
              </a>
            </li>
          </ul>
        </div>
      </div>
      {/*Logo Menu*/}
      <div className="flex flex-1 items-center justify-center">
        <img className="h-16" src="src/assets/logovertical.png" alt="" />
      </div>
      {/*Redes Menu*/}
      <div className="">
        <ul className="flex items-center justify-between w-1/12 gap-4">
          <li>
            <a
              href="https://facebook.com/"
              className="text-xl hover:text-[#ff010b] transition-colors"
            >
              <RiFacebookFill />
            </a>
          </li>
          <li>
            <a
              href="https://facebook.com/"
              className="text-xl hover:text-[#ff010b] transition-colors"
            >
              <RiInstagramLine />
            </a>
          </li>
          <li>
            <a
              href="https://facebook.com/"
              className="text-xl hover:text-[#ff010b] transition-colors"
            >
              <RiTwitterFill />
            </a>
          </li>
          <li>
            <a
              href="https://facebook.com/"
              className="text-xl hover:text-[#ff010b] transition-colors"
            >
              <RiYoutubeFill />
            </a>
          </li>
        </ul>
      </div>
    </header>
  );
};

export default Header;
